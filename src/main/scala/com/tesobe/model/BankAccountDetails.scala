/**
Open Bank Project - API
Copyright (C) 2011, 2013, TESOBE / Music Pictures Ltd

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

Email: contact@tesobe.com
TESOBE / Music Pictures Ltd
Osloerstrasse 16/17
Berlin 13359, Germany

  This product includes software developed at
  TESOBE (http://www.tesobe.com/)
  by
  Ayoub Benali: ayoub AT tesobe DOT com
  Nina Gänsdorfer: nina AT tesobe DOT com

 */
package com.tesobe.model

import net.liftweb.mapper._

class BankAccountDetails extends LongKeyedMapper[BankAccountDetails] {
  def getSingleton = BankAccountDetails

  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object accountNumber extends MappedString(this, 32)
  object bankNationalIdentifier extends MappedString(this, 32)
  object pinCode extends MappedString(this, 1024)
}

object BankAccountDetails extends BankAccountDetails with LongKeyedMetaMapper[BankAccountDetails]{
  override def dbIndexes = UniqueIndex(accountNumber, bankNationalIdentifier) ::super.dbIndexes
}