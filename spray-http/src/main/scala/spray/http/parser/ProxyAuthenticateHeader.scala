/*
 * Copyright (C) 2011-2013 spray.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spray
package http
package parser

import org.parboiled.scala._
import BasicRules._

private[parser] trait ProxyAuthenticateHeader extends WwwAuthenticateHeader {
  this: Parser with AdditionalRules ⇒

  def `*Proxy-Authenticate` = rule {
    oneOrMore(Challenge, separator = ListSep) ~ EOI ~~> (HttpHeaders.`Proxy-Authenticate`(_))
  }
}