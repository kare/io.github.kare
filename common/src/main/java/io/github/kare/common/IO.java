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
import java.util.logging.Level;
import java.util.logging.Logger;

/** Common IO utilities. */
public final class IO {
  private IO() {
    throw new AssertionError("No IO instances for you!");
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
