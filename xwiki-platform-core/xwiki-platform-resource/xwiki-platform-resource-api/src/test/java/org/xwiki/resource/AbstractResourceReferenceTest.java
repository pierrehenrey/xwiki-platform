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
package org.xwiki.resource;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link org.xwiki.resource.AbstractResourceReference}.
 *
 * @version $Id$
 * @since 6.1M2
 */
public class AbstractResourceReferenceTest
{
    public class TestableResourceReference extends AbstractResourceReference
    {
        @Override
        public void setParameter(String name, Object value)
        {
            super.setParameter(name, value);
        }
    }

    @Test
    void verifyToString()
    {
        TestableResourceReference reference = new TestableResourceReference();
        reference.setType(new ResourceType("test"));
        reference.addParameter("param1", "value1");

        assertEquals("type = [test], parameters = [[param1] = [[value1]]]", reference.toString());
    }

    @Test
    void setParameter()
    {
        TestableResourceReference reference = new TestableResourceReference();
        reference.addParameter("param", "value1");

        assertEquals(Arrays.asList("value1"), reference.getParameterValues("param"));

        reference.addParameter("param", "value2");

        assertEquals(Arrays.asList("value1", "value2"), reference.getParameterValues("param"));

        reference.setParameter("param", "value3");

        assertEquals(Arrays.asList("value3"), reference.getParameterValues("param"));
    }
}
