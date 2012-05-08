/*
 * This file is part of SpoutNBT.
 *
 * Copyright (c) 2012, SpoutDev <http://www.spout.org/>
 * SpoutNBT is licensed under the SpoutDev License Version 1.
 *
 * SpoutNBT is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * SpoutNBT is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.nbt;

import java.util.Arrays;

public class IntArrayTag extends Tag {
	/**
	 * The value.
	 */
	private final int[] value;

	/**
	 * Creates the tag.
	 * @param name The name.
	 * @param value The value.
	 */
	public IntArrayTag(String name, int[] value) {
		super(name);
		this.value = value;
	}

	@Override
	public int[] getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder hex = new StringBuilder();
		for (int s : value) {
			String hexDigits = Integer.toHexString(s).toUpperCase();
			if (hexDigits.length() == 1) {
				hex.append("0");
			}
			hex.append(hexDigits).append(" ");
		}

		String name = getName();
		String append = "";
		if (name != null && !name.equals("")) {
			append = "(\"" + this.getName() + "\")";
		}
		return "TAG_Short_Array" + append + ": " + hex.toString();
	}

	public IntArrayTag clone() {
		int[] clonedArray = cloneArray(value);

		return new IntArrayTag(getName(), clonedArray);
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof IntArrayTag)) {
			return false;

		}

		IntArrayTag tag = (IntArrayTag) other;
		return Arrays.equals(value, tag.value) && getName().equals(tag.getName());
	}

	private int[] cloneArray(int[] intArray) {
		if (intArray == null) {
			return null;
		} else {
			int length = intArray.length;
			byte[] newArray = new byte[length];
			System.arraycopy(intArray, 0, newArray, 0, length);
			return intArray;
		}
	}
}
