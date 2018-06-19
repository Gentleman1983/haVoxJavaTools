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
 * This is a little tool class to use for the need of switching more than two variables. This method allows to shift
 * values forward and backward in a list of items.
 *
 * @author Christian Otto
 * @version 1.00
 * @param <T> the item type.
 */
public class MultipleItemSwitcher<T>
{

  /**
   * This stores the items.
   */
  private LinkedList<T> items;

  /**
   * The standard constructor, that initializes the switcher with no objects. These have to be set later.
   */
  public MultipleItemSwitcher()
  {
    this.items = new LinkedList<>();
  }

  /**
   * The constructor which is used to initialize the switcher using a LinkedList of items.
   *
   * @param items The list of items.
   */
  public MultipleItemSwitcher( LinkedList<T> items )
  {
    this();
    this.items.addAll( items );
  }

  /**
   * This method adds an item in front of the item list.
   *
   * @param item The item.
   */
  public void addFrontItem( T item )
  {
    this.items.addFirst( item );
  }

  /**
   * This method adds an item in behind the item list.
   *
   * @param item The item.
   */
  public void addLastItem( T item )
  {
    this.items.addLast( item );
  }

  /**
   * This method adds a list of items in front of the list.
   *
   * @param items The list of items.
   */
  public void addFrontItems( LinkedList<T> items )
  {
    LinkedList<T> tempList = ( LinkedList<T> ) items.clone();
    tempList.addAll( this.items );
    this.items = tempList;
  }

  /**
   * This method sets a list of items behind the list.
   *
   * @param items The list of items.
   */
  public void addLastItems( LinkedList<T> items )
  {
    for ( T item : items )
    {
      this.items.addLast( item );
    }
  }

  /**
   * This method sets a list of items.
   *
   * @param items The list of items.
   */
  public void setItems( LinkedList<T> items )
  {
    this.items = ( LinkedList<T> ) items.clone();
  }

  /**
   * This returns a clone of the LinkedList of items.
   *
   * @return Clone of LinkedList of the items.
   */
  public LinkedList<T> getItems()
  {
    return ( LinkedList<T> ) this.items.clone();
  }

  /**
   * This method switches the items forward by one position.
   *
   * @return The switched list.
   * 
   * @throws IllegalArgumentException If less than two items on the list.
   */
  public LinkedList<T> switchItemsForward()
  {
    return switchItemsForward( 1 );
  }

  /**
   * This method switches the items forward by n positions.
   *
   * @param n The offset. Has to be greater or equal 1.
   * 
   * @return The switched list.
   * 
   * @throws IllegalArgumentException If less than two items on the list or n less or equal 0.
   */
  public LinkedList<T> switchItemsForward( int n )
  {
    return switchItemsBackward( this.items, n );
  }

  /**
   * This method switches the items backward by one position.
   *
   * @return The switched list.
   * 
   * @throws IllegalArgumentException If less than two items on the list.
   */
  public LinkedList<T> switchItemsBackward()
  {
    return switchItemsBackward( 1 );
  }

  /**
   * This method switches the items backward by n positions.
   *
   * @param n The offset. Has to be greater or equal 1.
   * 
   * @return The switched list.
   * 
   * @throws IllegalArgumentException If less than two items on the list or n less or equal 0.
   */
  public LinkedList<T> switchItemsBackward( int n )
  {
    return switchItemsBackward( this.items, n );
  }

  /**
   * This method switches the items forward by one position.
   *
   * @param items The LinkedList of items. It has to contain of at least two items.
   * 
   * @return The switched list.
   * 
   * @throws IllegalArgumentException If less than two items on the list.
   */
  public static LinkedList switchItemsForward( LinkedList items )
  {
    if ( items.size() <= 1 )
    {
      throw new IllegalArgumentException( "At least two values needed for switching values." );
    }

    items = ( LinkedList ) items.clone();
    Object tempItem = items.getLast();
    items.removeLast();
    items.addFirst( tempItem );
    return items;
  }

  /**
   * This method switches the items forward by n positions.
   *
   * @param items The LinkedList of items. It has to contain of at least two items.
   * @param n The offset. Has to be greater or equal 1.
   * 
   * @return The switched list.
   * 
   * @throws IllegalArgumentException If less than two items on the list or n less or equal 0.
   */
  public static LinkedList switchItemsForward( LinkedList items, int n )
  {
    if ( n <= 0 )
    {
      throw new IllegalArgumentException( "Values have to be greater than 0." );
    }
    for ( int i = 0; i < n; i++ )
    {
      items = switchItemsForward( items );
    }
    return items;
  }

  /**
   * This method switches the items backward by one position.
   *
   * @param items The LinkedList of items. It has to contain of at least two items.
   * 
   * @return The switched list.
   * 
   * @throws IllegalArgumentException If less than two items on the list.
   */
  public static LinkedList switchItemsBackward( LinkedList items )
  {
    if ( items.size() <= 1 )
    {
      throw new IllegalArgumentException( "At least two values needed for switching values." );
    }

    items = ( LinkedList ) items.clone();
    Object tempItem = items.getFirst();
    items.removeFirst();
    items.addLast( tempItem );
    return items;
  }

  /**
   * This method switches the items backward by n positions.
   *
   * @param items The LinkedList of items. It has to contain of at least two items.
   * @param n The offset. Has to be greater or equal 1.
   * 
   * @return The switched list.
   * 
   * @throws IllegalArgumentException If less than two items on the list or n less or equal 0.
   */
  public static LinkedList switchItemsBackward( LinkedList items, int n )
  {
    if ( n <= 0 )
    {
      throw new IllegalArgumentException( "Values have to be greater than 0." );
    }
    for ( int i = 0; i < n; i++ )
    {
      items = switchItemsBackward( items );
    }
    return items;
  }
}
