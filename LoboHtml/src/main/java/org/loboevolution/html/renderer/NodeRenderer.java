/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 Lobo Evolution

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
*/
/*
 * Created on Jan 29, 2006
 */
package org.loboevolution.html.renderer;

import org.loboevolution.html.dom.domimpl.NodeImpl;

/**
 * <p>NodeRenderer interface.</p>
 *
 * @author utente
 * @version $Id: $Id
 */
public interface NodeRenderer {
	/**
	 * <p>setRootNode.</p>
	 *
	 * @param node a {@link org.loboevolution.html.dom.domimpl.NodeImpl} object.
	 */
	void setRootNode(NodeImpl node);
}
