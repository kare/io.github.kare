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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.Test;

class IOTest {
  @Test
  void copyCopiesBytes() throws IOException {
    final byte[] expected = "Hello, World!".getBytes();
    OutputStream out = new ByteArrayOutputStream();
    long count = IO.copy(new ByteArrayInputStream(expected), out);
    assertArrayEquals(expected, out.toString().getBytes());
    assertEquals(expected.length, count);
  }

  @Test
  void closeClosesCloseables() {
    class BasicCloseable implements Closeable {
      boolean isCalled = false;

      @Override
      public void close() {
        isCalled = true;
      }
    }
    class ThrowingCloseable implements Closeable {
      boolean isCalled = false;

      @Override
      public void close() throws IOException {
        isCalled = true;
        throw new IOException("Mock class representing IO error");
      }
    }

    BasicCloseable c1 = new BasicCloseable();
    IO.close(c1);
    assertTrue(c1.isCalled);

    ThrowingCloseable t1 = new ThrowingCloseable();
    IO.close(t1);
    assertTrue(t1.isCalled);

    ThrowingCloseable t2 = new ThrowingCloseable();
    BasicCloseable c2 = new BasicCloseable();
    ThrowingCloseable t3 = new ThrowingCloseable();
    BasicCloseable c3 = new BasicCloseable();
    IO.close(null, t2, c2, null, t3, c3, null);
    assertTrue(t2.isCalled);
    assertTrue(c2.isCalled);
    assertTrue(t3.isCalled);
    assertTrue(c3.isCalled);
  }

  @Test
  void closeWithNoArgs() {
    IO.close();
    assertTrue(true);
  }

  @Test
  void closeWithNullCloseableArg() {
    Closeable closeable = null;
    IO.close(closeable);
    assertTrue(true);
  }

  @Test
  void closeThrowsWithNullCloseablesArray() {
    Closeable[] closeables = null;
    try {
      IO.close(closeables);
      fail("Excepting NullPointerException");
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }
}
