/*
 * Copyright 2017 [haVox] Design.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.havox.javatools.test.utils.random;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;

public class ModelRandomGenerator
{

  private static final SecureRandom RANDOM = new SecureRandom();

  public static final String ALPHANUMERIC_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  public static final String ALPHABETIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  private ModelRandomGenerator()
  {
  }

  public static String randomString( int length )
  {
    return randomString( length, ALPHANUMERIC_STRING );
  }

  public static String randomString( int length, String alphabet )
  {
    StringBuilder builder = new StringBuilder( length );
    for ( int i = 0; i < length; i++ )
    {
      builder.append( alphabet.charAt( RANDOM.nextInt( alphabet.length() ) ) );
    }
    return builder.toString();
  }

  public static int randomInt()
  {
    return RANDOM.nextInt();
  }

  public static int randomInt( int bound )
  {
    return RANDOM.nextInt( bound );
  }

  public static int randomIntInRange( int min, int max )
  {
    return randomInt( max - min + 1 ) + min;
  }

  public static long randomLong()
  {
    return RANDOM.nextLong();
  }

  public static boolean randomBoolean()
  {
    return RANDOM.nextBoolean();
  }

  public static double randomDouble()
  {
    return RANDOM.nextDouble();
  }

  public static float randomFloat()
  {
    return RANDOM.nextFloat();
  }

  public static LocalDate randomLocalDate()
  {
    return randomLocalDate( LocalDate.of( 1970, Month.JANUARY, 1 ), LocalDate.now() );
  }

  public static LocalDate randomLocalDate( LocalDate min, LocalDate max )
  {
    long minDay = min.toEpochDay();
    long maxDay = max.toEpochDay();
    long randomDay = ThreadLocalRandom.current().nextLong( minDay, maxDay );

    return LocalDate.ofEpochDay( randomDay );
  }

  public static LocalDateTime randomLocalDateTime()
  {
    return randomLocalDateTime( LocalDateTime.of( 1970, Month.JANUARY, 1, 0, 0 ), LocalDateTime.now() );
  }

  public static LocalDateTime randomLocalDateTime( LocalDateTime min, LocalDateTime max )
  {
    long minSecond = min.toEpochSecond( ZoneOffset.UTC );
    long maxSecond = max.toEpochSecond( ZoneOffset.UTC );
    long randomSecond = ThreadLocalRandom.current().nextLong( minSecond, maxSecond );

    return LocalDateTime.ofEpochSecond( randomSecond, 0, ZoneOffset.UTC );
  }
}
