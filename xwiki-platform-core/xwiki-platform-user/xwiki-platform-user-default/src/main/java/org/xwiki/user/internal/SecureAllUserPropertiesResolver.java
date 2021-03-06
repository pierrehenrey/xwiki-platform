/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.user.internal;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.configuration.ConfigurationSource;

/**
 * Looks in the "all" {@link ConfigurationSource} to get User properties (i.e. with full fallbacks) and returns a secure
 * {@link org.xwiki.user.UserProperties} object that performs permissions checks when reading/writing properties.
 *
 * @version $Id$
 * @since 12.4RC1
 */
@Component
@Named("secure/all")
@Singleton
public class SecureAllUserPropertiesResolver extends AbstractUserPropertiesResolver
{
    @Inject
    @Named("allsuperadminuser")
    private ConfigurationSource superAdminConfigurationSource;

    @Inject
    @Named("allguestuser")
    private ConfigurationSource guestConfigurationSource;

    @Override
    protected String getUnderlyingConfigurationSourceHint()
    {
        return "secure/all";
    }

    @Override
    protected ConfigurationSource getSuperAdminConfigurationSource()
    {
        return this.superAdminConfigurationSource;
    }

    @Override
    protected ConfigurationSource getGuestConfigurationSource()
    {
        return this.guestConfigurationSource;
    }
}
