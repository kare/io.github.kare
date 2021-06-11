/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.github.kare.common;

/** Common utilities that operate on {@code byte} arrays. */
public final class ByteArrays {
  private ByteArrays() {
    throw new AssertionError("No ByteArrays instances for you!");
  }

  /**
   * Convert an array of bytes to long. Only first eight bytes are considered.
   *
   * @param bytes Array of eight bytes
   * @return Returns given byte array as long
   * @throws ArrayIndexOutOfBoundsException Thrown if given array is not minimum of eight bytes in
   *     length
   * @throws NullPointerException Thrown if given array is null
   */
  public static long toLong(final byte[] bytes) {
    return ((long) (bytes[0]) << 56)
        + (((long) bytes[1] & 0xFF) << 48)
        + ((long) (bytes[2] & 0xFF) << 40)
        + ((long) (bytes[3] & 0xFF) << 32)
        + ((long) (bytes[4] & 0xFF) << 24)
        + ((bytes[5] & 0xFF) << 16)
        + ((bytes[6] & 0xFF) << 8)
        + (bytes[7] & 0xFF);
  }

  /**
   * Reverses given byte array.
   *
   * @param bytes Array of bytes
   * @throws NullPointerException Thrown if given array is null
   */
  public static void reverse(byte[] bytes) {
    for (int i = 0; i < bytes.length / 2; i++) {
      final int n = bytes.length - 1 - i;
      bytes[i] = (byte) ((int) bytes[i] ^ (int) bytes[n]);
      bytes[n] = (byte) ((int) bytes[i] ^ (int) bytes[n]);
      bytes[i] = (byte) ((int) bytes[i] ^ (int) bytes[n]);
    }
  }

  /**
   * Checks whether given {@code bytes} array contains value {@code b}.
   *
   * @param bytes Byte array to search
   * @param b byte to search in array bytes
   * @return true if given bytes contains b, false otherwise
   * @throws NullPointerException Thrown if given array is null
   */
  public static boolean contains(final byte[] bytes, final byte b) {
    for (final byte a : bytes) {
      if (a == b) {
        return true;
      }
    }
    return false;
  }
}
