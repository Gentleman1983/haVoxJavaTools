/*
 * Copyright 2014 [haVox] Design.
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

 /*
 * Package identifier.
 */
package net.havox.javatools.common.switcher;

/*
 * List of imported libraries.
 */
import java.util.LinkedList;

/**
 * This is a little tool class to use for the need of switching two variables. Often you need switching of variables and
 * you always have to implement a triangular switching of these variables. So this little helper class will be able to
 * help to end this.
 *
 * @author Christian Otto
 * @version 1.00
 * @param <T> the item type.
 */
public class ItemSwitcher<T>
{

  /**
   * This stores the first item.
   */
  private T itemA = null;

  /**
   * This stores the other item.
   */
  private T itemB = null;

  /**
   * The standard constructor, that initializes the switcher with no objects. These have to be set later.
   */
  public ItemSwitcher()
  {
  }

  /**
   * The constructor which is used to set both items on initialization.
   *
   * @param itemA The first item.
   * @param itemB The other item.
   */
  public ItemSwitcher( T itemA, T itemB )
  {
    this.itemA = itemA;
    this.itemB = itemB;
  }

  /**
   * This method sets the first item.
   *
   * @param itemA The first item.
   */
  public void setItemA( T itemA )
  {
    this.itemA = itemA;
  }

  /**
   * This method sets the other item.
   *
   * @param itemB The other item.
   */
  public void setItemB( T itemB )
  {
    this.itemB = itemB;
  }

  /**
   * This method sets both items.
   *
   * @param itemA The first item.
   * @param itemB The other item.
   */
  public void setItems( T itemA, T itemB )
  {
    this.itemA = itemA;
    this.itemB = itemB;
  }

  /**
   * This method returns the first item.
   *
   * @return The first item.
   */
  public T getItemA()
  {
    return this.itemA;
  }

  /**
   * This method returns the other item.
   *
   * @return The other item.
   */
  public T getItemB()
  {
    return this.itemB;
  }

  /**
   * This returns a LinkedList consisting of both items in initial order.
   *
   * @return LinkedList of both items.
   */
  public LinkedList<T> getItems()
  {
    LinkedList<T> list = new LinkedList<>();
    list.addFirst( this.itemA );
    list.addLast( this.itemB );
    return list;
  }

  /**
   * This returns a LinkedList consisting of both items in switched order.
   *
   * @return LinkedList of both items in switched order.
   */
  public LinkedList<T> switchItems()
  {
    return switchItems( this.itemA, this.itemB );
  }

  /**
   * This returns a LinkedList consisting of both items in switched order.
   *
   * @param itemA The first item.
   * @param itemB The other item.
   * 
   * @return LinkedList of both items in switched order.
   */
  public static LinkedList switchItems( Object itemA, Object itemB )
  {
    LinkedList list = new LinkedList();
    list.addFirst( itemB );
    list.addLast( itemA );
    return list;
  }

  /**
   * This returns a LinkedList consisting of both items in switched order.
   *
   * @param items A list of two items to switch.
   * 
   * @return LinkedList of both items in switched order.
   * 
   * @throws IllegalArgumentException If size is not equal two.
   */
  public static LinkedList switchItems( LinkedList items )
  {
    if ( items.size() != 2 )
    {
      throw new IllegalArgumentException( "Only a list consisting of two items is allowed for this switcher." );
    }

    return MultipleItemSwitcher.switchItemsForward( items );
  }
}
