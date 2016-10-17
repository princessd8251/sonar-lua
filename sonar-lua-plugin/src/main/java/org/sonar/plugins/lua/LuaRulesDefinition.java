/*
 * SonarQube Lua Plugin
 * Copyright (C) 2013-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.lua;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.lua.checks.CheckList;
//import org.sonar.plugins.lua.core.Flex;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

public final class LuaRulesDefinition implements RulesDefinition {

  private static final String REPOSITORY_NAME = "SonarQube";

  @Override
  public void define(Context context) {
    NewRepository repository = context
      .createRepository(CheckList.REPOSITORY_KEY, "lua")
      .setName(REPOSITORY_NAME);

    new AnnotationBasedRulesDefinition(repository, "lua").addRuleClasses(false, CheckList.getChecks());

    repository.done();
  }
}
