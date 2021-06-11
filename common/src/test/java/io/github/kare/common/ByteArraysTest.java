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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class ByteArraysTest {
  @Test
  void toLongByteArrayMustBeEightBytes() {
    try {
      ByteArrays.toLong(new byte[2]);
      fail("expecting ArrayIndexOutOfBoundsException");
    } catch (ArrayIndexOutOfBoundsException e) {
      assertTrue(true);
    }
  }

  @Test
  void toLongByteArrayMustNotBeNull() {
    try {
      ByteArrays.toLong(null);
      fail("expecting NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  void toLongConvertsEightByteArrayToLong() {
    byte[] expected = {
      1, 2, 3, 4, 5, 6, 7, 8,
    };
    long result = ByteArrays.toLong(expected);
    assertEquals(72623859790382856L, result);
    byte[] bytes = new BigInteger(String.valueOf(result)).toByteArray();
    assertArrayEquals(expected, bytes);
  }

  @Test
  void reverseByteArray() {
    byte[] expected = {1};
    byte[] given = {1};
    ByteArrays.reverse(given);
    assertArrayEquals(expected, given);

    expected = new byte[] {1, 2, 3, 4, 5, 6, 7, 8};
    given = new byte[] {8, 7, 6, 5, 4, 3, 2, 1};
    ByteArrays.reverse(given);
    assertArrayEquals(expected, given);

    expected =
        new byte[] {
          127, 126, 125, 124, 123, 122, 121, 120, 119, 118, 117, 116, 115, 114, 113, 112, 111, 110,
          109, 108, 107, 106, 105, 104, 103, 102, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90,
          89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68,
          67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46,
          45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24,
          23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1,
          -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19, -20,
          -21, -22, -23, -24, -25, -26, -27, -28, -29, -30, -31, -32, -33, -34, -35, -36, -37, -38,
          -39, -40, -41, -42, -43, -44, -45, -46, -47, -48, -49, -50, -51, -52, -53, -54, -55, -56,
          -57, -58, -59, -60, -61, -62, -63, -64, -65, -66, -67, -68, -69, -70, -71, -72, -73, -74,
          -75, -76, -77, -78, -79, -80, -81, -82, -83, -84, -85, -86, -87, -88, -89, -90, -91, -92,
          -93, -94, -95, -96, -97, -98, -99, -100, -101, -102, -103, -104, -105, -106, -107, -108,
          -109, -110, -111, -112, -113, -114, -115, -116, -117, -118, -119, -120, -121, -122, -123,
          -124, -125, -126, -127, -128
        };
    given =
        new byte[] {
          -128, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -117, -116, -115, -114,
          -113, -112, -111, -110, -109, -108, -107, -106, -105, -104, -103, -102, -101, -100, -99,
          -98, -97, -96, -95, -94, -93, -92, -91, -90, -89, -88, -87, -86, -85, -84, -83, -82, -81,
          -80, -79, -78, -77, -76, -75, -74, -73, -72, -71, -70, -69, -68, -67, -66, -65, -64, -63,
          -62, -61, -60, -59, -58, -57, -56, -55, -54, -53, -52, -51, -50, -49, -48, -47, -46, -45,
          -44, -43, -42, -41, -40, -39, -38, -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27,
          -26, -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9,
          -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
          17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
          39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
          61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82,
          83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103,
          104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121,
          122, 123, 124, 125, 126, 127,
        };
    ByteArrays.reverse(given);
    assertArrayEquals(expected, given);
  }

  @Test
  void reverseByteArrayMustNotBeNull() {
    try {
      ByteArrays.reverse(null);
      fail("expecting NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  void containsByteArrayMustNotBeNull() {
    try {
      ByteArrays.contains(null, (byte) 1);
      fail("expecting NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  void containsByteArray() {
    byte[] given = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    assertTrue(ByteArrays.contains(given, (byte) 0));
    assertTrue(ByteArrays.contains(given, (byte) 5));
    assertTrue(ByteArrays.contains(given, (byte) 10));
    assertFalse(ByteArrays.contains(given, (byte) 11));
    assertFalse(ByteArrays.contains(new byte[] {}, (byte) 11));
  }

  @Test
  void catNullArguments() {
    try {
      ByteArrays.cat(null, null);
      fail("expecting NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    }

    try {
      ByteArrays.cat(null, new byte[] {});
      fail("expecting NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    }

    try {
      ByteArrays.cat(new byte[] {}, null);
      fail("expecting NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  void catConcatenatesTwoArrays() {
    byte[] a = new byte[] {1};
    byte[] b = new byte[] {2};
    byte[] result = ByteArrays.cat(a, b);
    assertArrayEquals(new byte[] {1, 2}, result);

    a = new byte[] {1, 2, 3, 4, 5, 6, 7};
    b = new byte[] {-2, -1, 0, 1};
    result = ByteArrays.cat(a, b);
    assertArrayEquals(new byte[] {1, 2, 3, 4, 5, 6, 7, -2, -1, 0, 1}, result);
  }
}
