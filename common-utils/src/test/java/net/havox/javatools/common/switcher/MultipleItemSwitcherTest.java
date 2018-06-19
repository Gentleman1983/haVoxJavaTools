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
 * Imports.
 */
import static org.junit.Assert.*;

import java.util.LinkedList;
import org.junit.*;

/**
 * This is the test class for the item switcher for various size item lists.
 *
 * @author Christian Otto
 */
public final class MultipleItemSwitcherTest
{

  // Items.
  private static Object itemObject1;
  private static Object itemObject2;
  private static Object itemObject3;
  private static Object itemObject4;
  private static int itemInt1;
  private static int itemInt2;
  private static int itemInt3;
  private static int itemInt4;
  private static String itemString1;
  private static String itemString2;
  private static String itemString3;
  private static String itemString4;

  // Lists of items.
  private static LinkedList<Object> listObject1;
  private static LinkedList<Object> listObject2;
  private static LinkedList<Object> listObject3;
  private static LinkedList<Object> listObject4;
  private static LinkedList<Integer> listInt1;
  private static LinkedList<Integer> listInt2;
  private static LinkedList<Integer> listInt3;
  private static LinkedList<Integer> listInt4;
  private static LinkedList<String> listString1;
  private static LinkedList<String> listString2;
  private static LinkedList<String> listString3;
  private static LinkedList<String> listString4;

  // Switchers.
  private static MultipleItemSwitcher<Object> switcherObject1;
  private static MultipleItemSwitcher<Object> switcherObject2;
  private static MultipleItemSwitcher<Integer> switcherInt1;
  private static MultipleItemSwitcher<Integer> switcherInt2;
  private static MultipleItemSwitcher<String> switcherString1;
  private static MultipleItemSwitcher<String> switcherString2;

  /**
   * Constructor.
   */
  public MultipleItemSwitcherTest()
  {
  }

  /**
   * This is done before all tests.
   *
   * @throws Exception
   */
  @BeforeClass
  public static void setUpClass() throws Exception
  {
    // Initialization of the LinkedLists of items.
    listObject1 = new LinkedList<>();
    listObject2 = new LinkedList<>();
    listObject3 = new LinkedList<>();
    listObject4 = new LinkedList<>();
    listInt1 = new LinkedList<>();
    listInt2 = new LinkedList<>();
    listInt3 = new LinkedList<>();
    listInt4 = new LinkedList<>();
    listString1 = new LinkedList<>();
    listString2 = new LinkedList<>();
    listString3 = new LinkedList<>();
    listString4 = new LinkedList<>();
  }

  /**
   * This is done before every test.
   */
  @Before
  public void setUp()
  {
    // Initialization of the items.
    itemObject1 = new Object();
    itemObject2 = new Object();
    itemObject3 = new Object();
    itemObject4 = new Object();
    itemInt1 = 1;
    itemInt2 = 2;
    itemInt3 = 3;
    itemInt4 = 4;
    itemString1 = "item1";
    itemString2 = "item2";
    itemString3 = "item3";
    itemString4 = "item4";

    // Fill first list with one item.
    listObject1.add( itemObject1 );
    listInt1.add( itemInt1 );
    listString1.add( itemString1 );

    // Fill second list with two items.
    listObject2.add( itemObject1 );
    listObject2.add( itemObject2 );
    listInt2.add( itemInt1 );
    listInt2.add( itemInt2 );
    listString2.add( itemString1 );
    listString2.add( itemString2 );

    // Fill third list with three items.
    listObject3.add( itemObject1 );
    listObject3.add( itemObject2 );
    listObject3.add( itemObject3 );
    listInt3.add( itemInt1 );
    listInt3.add( itemInt2 );
    listInt3.add( itemInt3 );
    listString3.add( itemString1 );
    listString3.add( itemString2 );
    listString3.add( itemString3 );

    // Fill forth list with two items.
    listObject4.add( itemObject3 );
    listObject4.add( itemObject4 );
    listInt4.add( itemInt3 );
    listInt4.add( itemInt4 );
    listString4.add( itemString3 );
    listString4.add( itemString4 );
  }

  /**
   * This is done after every test.
   */
  @After
  public void tearDown()
  {
    // Empty all lists.
    listObject1.clear();
    listObject2.clear();
    listObject3.clear();
    listObject4.clear();
    listInt1.clear();
    listInt2.clear();
    listInt3.clear();
    listInt4.clear();
    listString1.clear();
    listString2.clear();
    listString3.clear();
    listString4.clear();

    // Reset all switchers.
    switcherObject1 = null;
    switcherObject2 = null;
    switcherInt1 = null;
    switcherInt2 = null;
    switcherString1 = null;
    switcherString2 = null;
  }

  /**
   * Test of getItems method, of class SwitchMultipleItems.
   */
  @Test
  public void testMultipleItemSwitcher()
  {
    assertNull( switcherObject1 );
    switcherObject1 = new MultipleItemSwitcher<>();
    assertNotNull( switcherObject1 );
    assertNotNull( switcherObject1.getItems() );
    assertTrue( switcherObject1.getItems().isEmpty() );
  }

  /**
   * Test of getItems method, of class SwitchMultipleItems.
   */
  @Test
  public void testMultipleItemSwitcherLinkedList()
  {
    assertNull( switcherObject1 );
    switcherObject1 = new MultipleItemSwitcher<>( listObject1 );
    assertNotNull( switcherObject1 );
    assertNotNull( switcherObject1.getItems() );
    assertFalse( switcherObject1.getItems().isEmpty() );
    assertEquals( listObject1, switcherObject1.getItems() );
    assertNotSame( listObject1, switcherObject1.getItems() );

    assertNull( switcherObject2 );
    switcherObject2 = new MultipleItemSwitcher<>( listObject2 );
    assertNotNull( switcherObject2 );
    assertNotNull( switcherObject2.getItems() );
    assertFalse( switcherObject2.getItems().isEmpty() );
    assertEquals( listObject2, switcherObject2.getItems() );
    assertNotSame( listObject2, switcherObject2.getItems() );
  }

  /**
   * Test of getItems method, of class SwitchMultipleItems.
   */
  @Test
  public void testGetItems()
  {
    assertNull( switcherObject1 );
    switcherObject1 = new MultipleItemSwitcher<>( listObject1 );
    assertNotNull( switcherObject1 );
    assertNotNull( switcherObject1.getItems() );
    assertFalse( switcherObject1.getItems().isEmpty() );
    assertEquals( listObject1, switcherObject1.getItems() );
    assertNotSame( listObject1, switcherObject1.getItems() );

    assertNull( switcherObject2 );
    switcherObject2 = new MultipleItemSwitcher<>( listObject2 );
    assertNotNull( switcherObject2 );
    assertNotNull( switcherObject2.getItems() );
    assertFalse( switcherObject2.getItems().isEmpty() );
    assertEquals( listObject2, switcherObject2.getItems() );
    assertNotSame( listObject2, switcherObject2.getItems() );
  }

  /**
   * Test of setItems method, of class SwitchMultipleItems.
   */
  @Test
  public void testSetItems()
  {
    assertNull( switcherObject1 );
    switcherObject1 = new MultipleItemSwitcher<>();
    assertNotNull( switcherObject1 );
    assertNotNull( switcherObject1.getItems() );
    assertTrue( switcherObject1.getItems().isEmpty() );
    switcherObject1.setItems( listObject3 );
    assertNotNull( switcherObject1.getItems() );
    assertFalse( switcherObject1.getItems().isEmpty() );
    assertEquals( listObject3, switcherObject1.getItems() );
    assertNotSame( listObject3, switcherObject1.getItems() );

    assertNull( switcherObject2 );
    switcherObject2 = new MultipleItemSwitcher<>( listObject2 );
    assertNotNull( switcherObject2 );
    assertNotNull( switcherObject2.getItems() );
    assertFalse( switcherObject2.getItems().isEmpty() );
    assertEquals( listObject2, switcherObject2.getItems() );
    assertNotSame( listObject2, switcherObject2.getItems() );
    switcherObject2.setItems( listObject4 );
    assertNotNull( switcherObject2.getItems() );
    assertFalse( switcherObject2.getItems().isEmpty() );
    assertEquals( listObject4, switcherObject2.getItems() );
    assertNotSame( listObject4, switcherObject2.getItems() );
  }

  /**
   * Test of addFrontItem method, of class SwitchMultipleItems.
   */
  @Test
  public void testAddFrontItem()
  {
    switcherObject1 = new MultipleItemSwitcher<>();
    LinkedList<Object> list1 = new LinkedList<>();
    switcherObject1.addFrontItem( itemObject1 );
    list1.addFirst( itemObject1 );
    assertEquals( list1, switcherObject1.getItems() );

    switcherObject2 = new MultipleItemSwitcher<>( listObject2 );
    LinkedList<Object> list2 = ( LinkedList<Object> ) listObject2.clone();
    switcherObject2.addFrontItem( itemObject4 );
    list2.addFirst( itemObject4 );
    assertEquals( list2, switcherObject2.getItems() );
  }

  /**
   * Test of addLastItem method, of class SwitchMultipleItems.
   */
  @Test
  public void testAddLastItem()
  {
    switcherObject1 = new MultipleItemSwitcher<>();
    LinkedList<Object> list1 = new LinkedList<>();
    switcherObject1.addLastItem( itemObject1 );
    list1.addLast( itemObject1 );
    assertEquals( list1, switcherObject1.getItems() );

    switcherObject2 = new MultipleItemSwitcher<>( listObject2 );
    LinkedList<Object> list2 = ( LinkedList<Object> ) listObject2.clone();
    switcherObject2.addLastItem( itemObject4 );
    list2.addLast( itemObject4 );
    assertEquals( list2, switcherObject2.getItems() );
  }

  /**
   * Test of addFrontItems method, of class SwitchMultipleItems.
   */
  @Test
  public void testAddFrontItems()
  {
    switcherObject1 = new MultipleItemSwitcher<>();
    LinkedList<Object> list1 = new LinkedList<>();
    switcherObject1.addFrontItems( listObject3 );
    LinkedList<Object> listtmp = ( LinkedList<Object> ) listObject3.clone();
    listtmp.addAll( list1 );
    list1 = listtmp;
    assertEquals( list1, switcherObject1.getItems() );

    switcherObject2 = new MultipleItemSwitcher<>( listObject2 );
    LinkedList<Object> list2 = ( LinkedList<Object> ) listObject2.clone();
    switcherObject2.addFrontItems( listObject4 );
    listtmp = ( LinkedList<Object> ) listObject4.clone();
    listtmp.addAll( list2 );
    list2 = listtmp;
    assertEquals( list2, switcherObject2.getItems() );
  }

  /**
   * Test of addLastItems method, of class SwitchMultipleItems.
   */
  @Test
  public void testAddLastItems()
  {
    switcherObject1 = new MultipleItemSwitcher<>();
    LinkedList<Object> list1 = new LinkedList<>();
    switcherObject1.addLastItem( itemObject1 );
    list1.addLast( itemObject1 );
    assertEquals( list1, switcherObject1.getItems() );

    switcherObject2 = new MultipleItemSwitcher<>( listObject2 );
    LinkedList<Object> list2 = ( LinkedList<Object> ) listObject2.clone();
    switcherObject2.addLastItem( itemObject4 );
    list2.addLast( itemObject4 );
    assertEquals( list2, switcherObject2.getItems() );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws Exception in case of an exception
   */
  @Test
  public void testSwitchItemsForwardZeroArgs() throws Exception
  {
    MultipleItemSwitcher instance = new MultipleItemSwitcher();

    LinkedList<Object> expResult = ( LinkedList<Object> ) listObject4.clone();
    Object lastItem = expResult.getLast();
    expResult.removeLast();
    expResult.addFirst( lastItem );

    instance.addFrontItems( listObject4 );

    LinkedList<Object> result = instance.switchItemsForward();
    assertEquals( expResult, result );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If not at least two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsForwardZeroArgsExceptionLessThanTwo()
  {
    MultipleItemSwitcher instance = new MultipleItemSwitcher();
    instance.addFrontItem( itemObject1 );
    instance.switchItemsForward();

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws Exception in case of an exception
   */
  @Test
  public void testSwitchItemsForwardInt() throws Exception
  {
    MultipleItemSwitcher instance = new MultipleItemSwitcher();
    instance.addFrontItems( listObject4 );
    LinkedList<Object> expResult = ( LinkedList<Object> ) listObject4.clone();
    LinkedList<Object> result = instance.switchItemsForward( 4 );
    assertEquals( expResult, result );

    Object lastItem = expResult.getLast();
    expResult.removeLast();
    expResult.addFirst( lastItem );
    result = instance.switchItemsForward( 1 );
    assertEquals( expResult, result );

    lastItem = expResult.getLast();
    expResult.removeLast();
    expResult.addFirst( lastItem );
    result = instance.switchItemsForward( 2 );
    assertEquals( expResult, result );

    lastItem = expResult.getLast();
    expResult.removeLast();
    expResult.addFirst( lastItem );
    result = instance.switchItemsForward( 3 );
    assertEquals( expResult, result );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If n less than one.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsForwardIntExceptionNLessThanOne()
  {
    int n = 0;
    MultipleItemSwitcher instance = new MultipleItemSwitcher();
    instance.addFrontItems( listObject4 );
    instance.switchItemsForward( n );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If LinkedList less than two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsForwardIntExceptionLinkedListLessThanTwo()
  {
    int n = 42;
    MultipleItemSwitcher instance = new MultipleItemSwitcher();
    instance.addFrontItem( itemObject1 );
    instance.switchItemsForward( n );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws Exception in case of an exception
   */
  @Test
  public void testSwitchItemsBackwardZeroArgs() throws Exception
  {
    MultipleItemSwitcher instance = new MultipleItemSwitcher();

    LinkedList<Object> expResult = ( LinkedList<Object> ) listObject4.clone();
    Object firstItem = expResult.getFirst();
    expResult.removeFirst();
    expResult.addLast( firstItem );

    instance.addFrontItems( listObject4 );

    LinkedList<Object> result = instance.switchItemsBackward();
    assertEquals( expResult, result );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If it has not at least two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsBackwardZeroArgsExceptionLessThanTwo()
  {
    MultipleItemSwitcher instance = new MultipleItemSwitcher();
    instance.addFrontItem( itemObject1 );
    instance.switchItemsBackward();

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws Exception in case of an exception
   */
  @Test
  public void testSwitchItemsBackwardInt() throws Exception
  {
    MultipleItemSwitcher instance = new MultipleItemSwitcher();
    instance.addFrontItems( listObject4 );
    LinkedList<Object> expResult = ( LinkedList<Object> ) listObject4.clone();
    LinkedList<Object> result = instance.switchItemsBackward( 4 );
    assertEquals( expResult, result );

    Object firstItem = expResult.getFirst();
    expResult.removeFirst();
    expResult.addLast( firstItem );
    result = instance.switchItemsBackward( 1 );
    assertEquals( expResult, result );

    firstItem = expResult.getFirst();
    expResult.removeFirst();
    expResult.addLast( firstItem );
    result = instance.switchItemsBackward( 2 );
    assertEquals( expResult, result );

    firstItem = expResult.getFirst();
    expResult.removeFirst();
    expResult.addLast( firstItem );
    result = instance.switchItemsBackward( 3 );
    assertEquals( expResult, result );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If LinkedList is not at least two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsBackwardIntExceptionLinkedListLessThanTwo()
  {
    int n = 42;
    MultipleItemSwitcher instance = new MultipleItemSwitcher();
    instance.addFrontItem( itemObject1 );
    instance.switchItemsBackward( n );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If n is smaller than 1.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsBackwardIntExceptionNLessThanOne()
  {
    int n = 0;
    MultipleItemSwitcher instance = new MultipleItemSwitcher();
    instance.addFrontItems( listObject4 );
    instance.switchItemsBackward( n );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws Exception in case of an exception
   */
  @Test
  public void testSwitchItemsForwardLinkedList() throws Exception
  {
    LinkedList<Object> items = listObject4;
    LinkedList<Object> expResult = ( LinkedList<Object> ) listObject4.clone();
    Object lastObject = expResult.getLast();
    expResult.removeLast();
    expResult.addFirst( lastObject );
    LinkedList<Object> result
            = MultipleItemSwitcher.switchItemsForward( items );
    assertEquals( expResult, result );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If it has not at least two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsForwardLinkedListExceptionLessThanTwo()
  {
    LinkedList<Object> items = listObject1;
    MultipleItemSwitcher.switchItemsForward( items );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws Exception in case of an exception
   */
  @Test
  public void testSwitchItemsForwardLinkedListInt() throws Exception
  {
    LinkedList<Object> item = ( LinkedList<Object> ) listObject4.clone();
    LinkedList<Object> expResult = ( LinkedList<Object> ) listObject4.clone();
    LinkedList<Object> result
            = MultipleItemSwitcher.switchItemsForward( item, 4 );
    assertEquals( expResult, result );

    Object firstItem = expResult.getFirst();
    expResult.removeFirst();
    expResult.addLast( firstItem );
    result = MultipleItemSwitcher.switchItemsForward( item, 1 );
    assertEquals( expResult, result );

    firstItem = expResult.getFirst();
    expResult.removeFirst();
    expResult.addLast( firstItem );
    result = MultipleItemSwitcher.switchItemsForward( item, 2 );
    assertEquals( expResult, result );

    firstItem = expResult.getFirst();
    expResult.removeFirst();
    expResult.addLast( firstItem );
    result = MultipleItemSwitcher.switchItemsForward( item, 3 );
    assertEquals( expResult, result );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If n is less than 1.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsForwardLinkedListIntExceptionNLessThanOne()
  {
    int n = 0;
    LinkedList<Object> items = listObject4;
    MultipleItemSwitcher.switchItemsForward( items, n );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsForward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If LinkedList has not at least two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void
          testSwitchItemsForwardLinkedListIntExceptionLinkedListLessThanTwo()
  {
    int n = 42;
    LinkedList<Object> items = listObject1;
    MultipleItemSwitcher.switchItemsForward( items, n );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws Exception in case of an exception
   */
  @Test
  public void testSwitchItemsBackwardLinkedList() throws Exception
  {
    LinkedList<Object> items = listObject4;
    LinkedList<Object> expResult = ( LinkedList<Object> ) listObject4.clone();
    Object firstObject = expResult.getFirst();
    expResult.removeFirst();
    expResult.addLast( firstObject );
    LinkedList<Object> result = MultipleItemSwitcher.switchItemsForward( items );
    assertEquals( expResult, result );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If not at least two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsBackwardLinkedListExceptionLessThanTwo()
  {
    LinkedList<Object> items = listObject1;
    MultipleItemSwitcher.switchItemsBackward( items );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws Exception in case of an exception
   */
  @Test
  public void testSwitchItemsBackwardLinkedListInt() throws Exception
  {
    LinkedList<Object> item = ( LinkedList<Object> ) listObject4.clone();
    LinkedList<Object> expResult = ( LinkedList<Object> ) listObject4.clone();
    LinkedList<Object> result
            = MultipleItemSwitcher.switchItemsBackward( item, 4 );
    assertEquals( expResult, result );

    Object lastItem = expResult.getLast();
    expResult.removeLast();
    expResult.addFirst( lastItem );
    result = MultipleItemSwitcher.switchItemsBackward( item, 1 );
    assertEquals( expResult, result );

    lastItem = expResult.getLast();
    expResult.removeLast();
    expResult.addFirst( lastItem );
    result = MultipleItemSwitcher.switchItemsBackward( item, 2 );
    assertEquals( expResult, result );

    lastItem = expResult.getLast();
    expResult.removeLast();
    expResult.addFirst( lastItem );
    result = MultipleItemSwitcher.switchItemsBackward( item, 3 );
    assertEquals( expResult, result );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If LinkedList is less than two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void
          testSwitchItemsBackwardLinkedListIntExceptionLinkedListLessThanTwo()
  {
    int n = 42;
    LinkedList<Object> items = listObject1;
    MultipleItemSwitcher.switchItemsBackward( items, n );

    fail( "This should never be reached!!!" );
  }

  /**
   * Test of switchItemsBackward method, of class SwitchMultipleItems.
   *
   * @throws IllegalArgumentException If n is less than one.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsBackwardLinkedListIntExceptionNLessThanOne()
  {
    int n = 0;
    LinkedList<Object> items = listObject4;
    MultipleItemSwitcher.switchItemsBackward( items, n );

    fail( "This should never be reached!!!" );
  }
}
