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

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Common IO utilities. */
public final class IO {
  /** Copy buffer size in bytes. */
  private static final int COPY_BUFFER_SIZE = 1024 * 4;

  private IO() {
    throw new AssertionError("No IO instances for you!");
  }

  /**
   * Copy bytes from input stream {@code in} to output stream {@code out}.
   *
   * @param in Input stream to read bytes from
   * @param out Output stream to write bytes to
   * @return Number of bytes copies
   * @throws IOException Thrown in case of I/O error
   * @throws NullPointerException If either given in or out is null
   */
  public static long copy(final InputStream in, final OutputStream out) throws IOException {
    final byte[] buf = new byte[COPY_BUFFER_SIZE];
    int n;
    long byteCount = 0;
    while ((n = in.read(buf, 0, buf.length)) != -1) {
      out.write(buf, 0, n);
      byteCount += n;
    }
    return byteCount;
  }

  /**
   * Close given Closeables unless they're null.
   *
   * @param closeables Closeable instances to call close()
   * @throws NullPointerException If given closeables array is null
   */
  public static void close(final Closeable... closeables) {
    for (final Closeable closeable : closeables) {
      if (closeable != null) {
        try {
          closeable.close();
        } catch (final IOException e) {
          Logger logger = Logger.getLogger(IO.class.getName());
          logger.log(Level.SEVERE, "Error while closing I/O resource", e);
        }
      }
    }
  }
}
