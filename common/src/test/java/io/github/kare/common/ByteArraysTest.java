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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class ByteArraysTest {
  @Test
  void givenByteArrayMustBeEightBytes() {
    try {
      ByteArrays.toLong(new byte[2]);
      fail("expecting ArrayIndexOutOfBoundsException");
    } catch (ArrayIndexOutOfBoundsException e) {
      assertTrue(true);
    }
  }

  @Test
  void givenByteArrayMustNotBeNull() {
    try {
      ByteArrays.toLong(null);
      fail("expecting NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  void convertsEightByteArrayToLong() {
    byte[] expected = {
      1, 2, 3, 4, 5, 6, 7, 8,
    };
    long result = ByteArrays.toLong(expected);
    assertEquals(72623859790382856L, result);
    byte[] bytes = new BigInteger(String.valueOf(result)).toByteArray();
    assertArrayEquals(expected, bytes);
  }
}
