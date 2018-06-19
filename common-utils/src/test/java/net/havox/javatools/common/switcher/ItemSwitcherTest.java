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
 * This is the test class for the item switcher.
 *
 * @author Christian Otto
 */
public final class ItemSwitcherTest
{

  // Items.
  private static Object item1;
  private static Object item2;
  private static Object item3;
  private static Object item4;
  private static int itemInt1;
  private static int itemInt2;
  private static int itemInt3;
  private static int itemInt4;
  private static String itemString1;
  private static String itemString2;
  private static String itemString3;
  private static String itemString4;

  // Lists of items.
  private static LinkedList<Object> list1;
  private static LinkedList<Object> list2;
  private static LinkedList<Object> list3;
  private static LinkedList<Object> list4;
  private static LinkedList<Integer> listInt1;
  private static LinkedList<Integer> listInt2;
  private static LinkedList<Integer> listInt3;
  private static LinkedList<Integer> listInt4;
  private static LinkedList<String> listString1;
  private static LinkedList<String> listString2;
  private static LinkedList<String> listString3;
  private static LinkedList<String> listString4;

  // Switchers.
  private static ItemSwitcher<Object> switcher1;
  private static ItemSwitcher<Object> switcher2;
  private static ItemSwitcher<Integer> switcherInt1;
  private static ItemSwitcher<Integer> switcherInt2;
  private static ItemSwitcher<String> switcherString1;
  private static ItemSwitcher<String> switcherString2;

  /**
   * Constructor.
   */
  public ItemSwitcherTest()
  {
  }

  /**
   * This is done before all tests.
   */
  @BeforeClass
  public static void setUpClass()
  {
    // Initialization of the LinkedLists of items.
    list1 = new LinkedList<>();
    list2 = new LinkedList<>();
    list3 = new LinkedList<>();
    list4 = new LinkedList<>();
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
    item1 = new Object();
    item2 = new Object();
    item3 = new Object();
    item4 = new Object();
    itemInt1 = 1;
    itemInt2 = 2;
    itemInt3 = 3;
    itemInt4 = 4;
    itemString1 = "item1";
    itemString2 = "item2";
    itemString3 = "item3";
    itemString4 = "item4";

    // Fill first list with one item.
    list1.add( item1 );
    listInt1.add( itemInt1 );
    listString1.add( itemString1 );

    // Fill second list with two items.
    list2.add( item1 );
    list2.add( item2 );
    listInt2.add( itemInt1 );
    listInt2.add( itemInt2 );
    listString2.add( itemString1 );
    listString2.add( itemString2 );

    // Fill third list with three items.
    list3.add( item1 );
    list3.add( item2 );
    list3.add( item3 );
    listInt3.add( itemInt1 );
    listInt3.add( itemInt2 );
    listInt3.add( itemInt3 );
    listString3.add( itemString1 );
    listString3.add( itemString2 );
    listString3.add( itemString3 );

    // Fill forth list with two items.
    list4.add( item3 );
    list4.add( item4 );
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
    list1.clear();
    list2.clear();
    list3.clear();
    list4.clear();
    listInt1.clear();
    listInt2.clear();
    listInt3.clear();
    listInt4.clear();
    listString1.clear();
    listString2.clear();
    listString3.clear();
    listString4.clear();

    // Reset all switchers.
    switcher1 = null;
    switcher2 = null;
    switcherInt1 = null;
    switcherInt2 = null;
    switcherString1 = null;
    switcherString2 = null;
  }

  // Test runs for objects.
  /**
   * Test of constructor method, of class SwitchItems.
   */
  @Test
  public void testConstructor()
  {
    // Create empty instance of switcher1.
    switcher1 = new ItemSwitcher<>();
    // The switcher itself should not be null, but both items.
    assertNotNull( switcher1 );
    assertNull( switcher1.getItemA() );
    assertNull( switcher1.getItemB() );

    // Create empty instance of switcher2.
    switcher2 = new ItemSwitcher<>();
    // The switcher itself should not be null, but both items.
    assertNotNull( switcher2 );
    assertNull( switcher2.getItemA() );
    assertNull( switcher2.getItemB() );
  }

  /**
   * Test of constructor method, of class SwitchItems.
   */
  @Test
  public void testConstructorTypeType()
  {
    // Create non-empty instance of switcher1.
    switcher1 = new ItemSwitcher<>( item3, item4 );
    // The switcher and both items should not be null.
    assertNotNull( switcher1 );
    assertNotNull( switcher1.getItemA() );
    assertNotNull( switcher1.getItemB() );
    // ItemA = item3, ItemB = item4.
    assertEquals( item3, switcher1.getItemA() );
    assertSame( item3, switcher1.getItemA() );
    assertNotSame( item1, switcher1.getItemA() );
    assertNotSame( item2, switcher1.getItemA() );
    assertNotSame( item4, switcher1.getItemA() );
    assertEquals( item4, switcher1.getItemB() );
    assertSame( item4, switcher1.getItemB() );
    assertNotSame( item1, switcher1.getItemB() );
    assertNotSame( item2, switcher1.getItemB() );
    assertNotSame( item3, switcher1.getItemB() );

    // Create non-empty instance of switcher2.
    switcher2 = new ItemSwitcher<>( item1, item2 );
    // The switcher and both items should not be null.
    assertNotNull( switcher2 );
    assertNotNull( switcher2.getItemA() );
    assertNotNull( switcher2.getItemB() );
    // ItemA = item1, ItemB = item2.
    assertEquals( item1, switcher2.getItemA() );
    assertSame( item1, switcher2.getItemA() );
    assertNotSame( item2, switcher2.getItemA() );
    assertNotSame( item3, switcher2.getItemA() );
    assertNotSame( item4, switcher2.getItemA() );
    assertEquals( item2, switcher2.getItemB() );
    assertSame( item2, switcher2.getItemB() );
    assertNotSame( item1, switcher2.getItemB() );
    assertNotSame( item3, switcher2.getItemB() );
    assertNotSame( item3, switcher2.getItemB() );
  }

  /**
   * Test of setItemA method, of class SwitchItems.
   */
  @Test
  public void testSetItemA()
  {
    // Initialize switchers.
    switcher1 = new ItemSwitcher<>();
    switcher2 = new ItemSwitcher<>( item1, item2 );

    // Test for empty switcher.
    assertNull( switcher1.getItemA() );
    switcher1.setItemA( item1 );
    assertNotNull( switcher1.getItemA() );
    assertEquals( item1, switcher1.getItemA() );
    assertSame( item1, switcher1.getItemA() );

    // Test for non-empty switcher.
    assertNotNull( switcher2.getItemA() );
    assertEquals( item1, switcher2.getItemA() );
    assertSame( item1, switcher2.getItemA() );
    switcher2.setItemA( item2 );
    assertFalse( item1.equals( item2 ) );
    assertNotSame( item1, item2 );
    assertNotNull( switcher1.getItemA() );
    assertEquals( item2, switcher2.getItemA() );
    assertSame( item2, switcher2.getItemA() );
  }

  /**
   * Test of setItemB method, of class SwitchItems.
   */
  @Test
  public void testSetItemB()
  {
    // Initialize switchers.
    switcher1 = new ItemSwitcher<>();
    switcher2 = new ItemSwitcher<>( item1, item2 );

    // Test for empty switcher.
    assertNull( switcher1.getItemB() );
    switcher1.setItemB( item1 );
    assertNotNull( switcher1.getItemB() );
    assertEquals( item1, switcher1.getItemB() );
    assertSame( item1, switcher1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcher2.getItemB() );
    assertEquals( item2, switcher2.getItemB() );
    assertSame( item2, switcher2.getItemB() );
    switcher2.setItemB( item1 );
    assertFalse( item1.equals( item2 ) );
    assertNotSame( item1, item2 );
    assertNotNull( switcher1.getItemB() );
    assertEquals( item1, switcher2.getItemB() );
    assertSame( item1, switcher2.getItemB() );
  }

  /**
   * Test of setItems method, of class SwitchItems.
   */
  @Test
  public void testSetItems()
  {
    // Initialize switchers.
    switcher1 = new ItemSwitcher<>();
    switcher2 = new ItemSwitcher<>( item1, item2 );

    // Test for empty switcher.
    assertNull( switcher1.getItemA() );
    assertNull( switcher1.getItemB() );
    switcher1.setItems( item1, item2 );
    assertNotNull( switcher1.getItemA() );
    assertEquals( item1, switcher1.getItemA() );
    assertSame( item1, switcher1.getItemA() );
    assertNotNull( switcher1.getItemB() );
    assertEquals( item2, switcher1.getItemB() );
    assertSame( item2, switcher1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcher2.getItemA() );
    assertEquals( item1, switcher2.getItemA() );
    assertSame( item1, switcher2.getItemA() );
    assertNotNull( switcher2.getItemB() );
    assertEquals( item2, switcher2.getItemB() );
    assertSame( item2, switcher2.getItemB() );
    switcher2.setItems( item3, item4 );
    assertFalse( item1.equals( item3 ) );
    assertNotSame( item1, item3 );
    assertFalse( item2.equals( item4 ) );
    assertNotSame( item2, item4 );
    assertNotNull( switcher2.getItemA() );
    assertEquals( item3, switcher2.getItemA() );
    assertSame( item3, switcher2.getItemA() );
    assertNotNull( switcher2.getItemB() );
    assertEquals( item4, switcher2.getItemB() );
    assertSame( item4, switcher2.getItemB() );
  }

  /**
   * Test of getItemA method, of class SwitchItems.
   */
  @Test
  public void testGetItemA()
  {
    // Initialize switchers.
    switcher1 = new ItemSwitcher<>();
    switcher2 = new ItemSwitcher<>( item1, item2 );

    // Test for empty switcher.
    assertNull( switcher1.getItemA() );

    // Test for non-empty switcher.
    assertNotNull( switcher2.getItemA() );
    assertEquals( item1, switcher2.getItemA() );
    assertSame( item1, switcher2.getItemA() );
  }

  /**
   * Test of getItemB method, of class SwitchItems.
   */
  @Test
  public void testGetItemB()
  {
    // Initialize switchers.
    switcher1 = new ItemSwitcher<>();
    switcher2 = new ItemSwitcher<>( item1, item2 );

    // Test for empty switcher.
    assertNull( switcher1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcher2.getItemB() );
    assertEquals( item2, switcher2.getItemB() );
    assertSame( item2, switcher2.getItemB() );
  }

  /**
   * Test of getItems method, of class SwitchItems.
   */
  @Test
  public void testGetItems()
  {
    // Initialize switchers.
    switcher1 = new ItemSwitcher<>();
    switcher2 = new ItemSwitcher<>( item1, item2 );

    // Test for empty switcher.
    assertEquals( 2, switcher1.getItems().size() );
    assertNull( switcher1.getItems().getFirst() );
    assertNull( switcher1.getItems().getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, switcher2.getItems().size() );
    assertEquals( item1, switcher2.getItems().getFirst() );
    assertSame( item1, switcher2.getItems().getFirst() );
    assertEquals( item2, switcher2.getItems().getLast() );
    assertSame( item2, switcher2.getItems().getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   */
  @Test
  public void testSwitchItemsZeroargs()
  {
    // Initialize switchers.
    switcher1 = new ItemSwitcher<>();
    switcher2 = new ItemSwitcher<>( item1, item2 );

    // Test for empty switcher.
    assertEquals( 2, switcher1.switchItems().size() );
    assertNull( switcher1.switchItems().getFirst() );
    assertNull( switcher1.switchItems().getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, switcher2.switchItems().size() );
    assertEquals( switcher2.getItemB(), switcher2.switchItems().getFirst() );
    assertSame( switcher2.getItemB(), switcher2.switchItems().getFirst() );
    assertEquals( switcher2.getItemA(), switcher2.switchItems().getLast() );
    assertSame( switcher2.getItemA(), switcher2.switchItems().getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   */
  @Test
  public void testSwitchItemsObjectObject()
  {
    // Test for half-empty switcher.
    assertEquals( 2, ItemSwitcher.switchItems( item1, null ).size() );
    assertNull( ItemSwitcher.switchItems( item1, null ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( item1, null ).getLast() );
    assertEquals( item1, ItemSwitcher.switchItems( item1, null ).getLast() );
    assertSame( item1, ItemSwitcher.switchItems( item1, null ).getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, ItemSwitcher.switchItems( item1, item2 ).size() );
    assertNotNull( ItemSwitcher.switchItems( item1, item2 ).getFirst() );
    assertEquals( item2, ItemSwitcher.switchItems( item1, item2 ).getFirst() );
    assertSame( item2, ItemSwitcher.switchItems( item1, item2 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( item1, item2 ).getLast() );
    assertEquals( item1, ItemSwitcher.switchItems( item1, item2 ).getLast() );
    assertSame( item1, ItemSwitcher.switchItems( item1, item2 ).getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If more than two items.
   */
  @Test
  public void testSwitchItemsLinkedList()
  {
    // Try on list2.
    assertEquals( 2, list2.size() );
    assertEquals( 2, ItemSwitcher.switchItems( list2 ).size() );
    assertNotNull( ItemSwitcher.switchItems( list2 ).getFirst() );
    assertEquals( item2, ItemSwitcher.switchItems( list2 ).getFirst() );
    assertSame( item2, ItemSwitcher.switchItems( list2 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( list2 ).getLast() );
    assertEquals( item1, ItemSwitcher.switchItems( list2 ).getLast() );
    assertSame( item1, ItemSwitcher.switchItems( list2 ).getLast() );

    // Try on list4.
    assertEquals( 2, list4.size() );
    assertEquals( 2, ItemSwitcher.switchItems( list4 ).size() );
    assertNotNull( ItemSwitcher.switchItems( list4 ).getFirst() );
    assertEquals( item4, ItemSwitcher.switchItems( list4 ).getFirst() );
    assertSame( item4, ItemSwitcher.switchItems( list4 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( list4 ).getLast() );
    assertEquals( item3, ItemSwitcher.switchItems( list4 ).getLast() );
    assertSame( item3, ItemSwitcher.switchItems( list4 ).getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionLessThanTwo()
  {
    assertTrue( list1.size() < 2 );
    LinkedList<Object> testList = ItemSwitcher.switchItems( list1 );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionLessThanTwo2()
  {
    LinkedList<Object> test = new LinkedList<>();
    assertTrue( test.size() < 2 );
    LinkedList<Object> testList = ItemSwitcher.switchItems( test );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionMoreThanTwo()
  {
    assertTrue( list3.size() > 2 );
    LinkedList<Object> testList = ItemSwitcher.switchItems( list3 );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionMoreThanTwo2()
  {
    LinkedList<Object> test = new LinkedList<>();
    test.addAll( list1 );
    test.addAll( list2 );
    test.addAll( list3 );
    test.addAll( list4 );
    assertTrue( test.size() > 2 );
    LinkedList<Object> testList = ItemSwitcher.switchItems( test );
  }

  // Test runs for integer values.
  /**
   * Test of constructor method, of class SwitchItems.
   */
  @Test
  public void testConstructorInt()
  {
    // Create empty instance of switcher1.
    switcherInt1 = new ItemSwitcher<>();
    // The switcher itself should not be null, but both items.
    assertNotNull( switcherInt1 );
    assertNull( switcherInt1.getItemA() );
    assertNull( switcherInt1.getItemB() );

    // Create empty instance of switcher2.
    switcherInt2 = new ItemSwitcher<>();
    // The switcher itself should not be null, but both items.
    assertNotNull( switcherInt2 );
    assertNull( switcherInt2.getItemA() );
    assertNull( switcherInt2.getItemB() );
  }

  /**
   * Test of constructor method, of class SwitchItems.
   */
  @Test
  public void testConstructorTypeTypeInt()
  {
    // Create non-empty instance of switcher1.
    switcherInt1 = new ItemSwitcher<>( itemInt3, itemInt4 );
    // The switcher and both items should not be null.
    assertNotNull( switcherInt1 );
    assertNotNull( switcherInt1.getItemA() );
    assertNotNull( switcherInt1.getItemB() );
    // ItemA = item3, ItemB = item4.
    assertTrue( itemInt3 == switcherInt1.getItemA() );
    assertTrue( itemInt4 == switcherInt1.getItemB() );

    // Create non-empty instance of switcher2.
    switcherInt2 = new ItemSwitcher<>( itemInt1, itemInt2 );
    // The switcher and both items should not be null.
    assertNotNull( switcherInt2 );
    assertNotNull( switcherInt2.getItemA() );
    assertNotNull( switcherInt2.getItemB() );
    // ItemA = item1, ItemB = item2.
    assertTrue( itemInt1 == switcherInt2.getItemA() );
    assertTrue( itemInt2 == switcherInt2.getItemB() );
  }

  /**
   * Test of setItemA method, of class SwitchItems.
   */
  @Test
  public void testSetItemAInt()
  {
    // Initialize switchers.
    switcherInt1 = new ItemSwitcher<>();
    switcherInt2 = new ItemSwitcher<>( itemInt1, itemInt2 );

    // Test for empty switcher.
    assertNull( switcherInt1.getItemA() );
    switcherInt1.setItemA( itemInt1 );
    assertNotNull( switcherInt1.getItemA() );
    assertTrue( itemInt1 == switcherInt1.getItemA() );

    // Test for non-empty switcher.
    assertNotNull( switcherInt2.getItemA() );
    assertTrue( itemInt1 == switcherInt2.getItemA() );
    switcherInt2.setItemA( itemInt2 );
    assertFalse( itemInt1 == itemInt2 );
    assertNotNull( switcherInt1.getItemA() );
    assertTrue( itemInt2 == switcherInt2.getItemA() );
  }

  /**
   * Test of setItemB method, of class SwitchItems.
   */
  @Test
  public void testSetItemBInt()
  {
    // Initialize switchers.
    switcherInt1 = new ItemSwitcher<>();
    switcherInt2 = new ItemSwitcher<>( itemInt1, itemInt2 );

    // Test for empty switcher.
    assertNull( switcherInt1.getItemB() );
    switcherInt1.setItemB( itemInt1 );
    assertNotNull( switcherInt1.getItemB() );
    assertTrue( itemInt1 == switcherInt1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcherInt2.getItemB() );
    assertTrue( itemInt2 == switcherInt2.getItemB() );
    switcherInt2.setItemB( itemInt1 );
    assertFalse( itemInt1 == itemInt2 );
    assertNotNull( switcherInt1.getItemB() );
    assertTrue( itemInt1 == switcherInt2.getItemB() );
  }

  /**
   * Test of setItems method, of class SwitchItems.
   */
  @Test
  public void testSetItemsInt()
  {
    // Initialize switchers.
    switcherInt1 = new ItemSwitcher<>();
    switcherInt2 = new ItemSwitcher<>( itemInt1, itemInt2 );

    // Test for empty switcher.
    assertNull( switcherInt1.getItemA() );
    assertNull( switcherInt1.getItemB() );
    switcherInt1.setItems( itemInt1, itemInt2 );
    assertNotNull( switcherInt1.getItemA() );
    assertTrue( itemInt1 == switcherInt1.getItemA() );
    assertNotNull( switcherInt1.getItemB() );
    assertTrue( itemInt2 == switcherInt1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcherInt2.getItemA() );
    assertTrue( itemInt1 == switcherInt2.getItemA() );
    assertNotNull( switcherInt2.getItemB() );
    assertTrue( itemInt2 == switcherInt2.getItemB() );
    switcherInt2.setItems( itemInt3, itemInt4 );
    assertFalse( itemInt1 == itemInt3 );
    assertFalse( itemInt2 == itemInt4 );
    assertNotNull( switcherInt2.getItemA() );
    assertTrue( itemInt3 == switcherInt2.getItemA() );
    assertNotNull( switcherInt2.getItemB() );
    assertTrue( itemInt4 == switcherInt2.getItemB() );
  }

  /**
   * Test of getItemA method, of class SwitchItems.
   */
  @Test
  public void testGetItemAInt()
  {
    // Initialize switchers.
    switcherInt1 = new ItemSwitcher<>();
    switcherInt2 = new ItemSwitcher<>( itemInt1, itemInt2 );

    // Test for empty switcher.
    assertNull( switcherInt1.getItemA() );

    // Test for non-empty switcher.
    assertNotNull( switcherInt2.getItemA() );
    assertTrue( itemInt1 == switcherInt2.getItemA() );
  }

  /**
   * Test of getItemB method, of class SwitchItems.
   */
  @Test
  public void testGetItemBInt()
  {
    // Initialize switchers.
    switcherInt1 = new ItemSwitcher<>();
    switcherInt2 = new ItemSwitcher<>( itemInt1, itemInt2 );

    // Test for empty switcher.
    assertNull( switcherInt1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcherInt2.getItemB() );
    assertTrue( itemInt2 == switcherInt2.getItemB() );
  }

  /**
   * Test of getItems method, of class SwitchItems.
   */
  @Test
  public void testGetItemsInt()
  {
    // Initialize switchers.
    switcherInt1 = new ItemSwitcher<>();
    switcherInt2 = new ItemSwitcher<>( itemInt1, itemInt2 );

    // Test for empty switcher.
    assertEquals( 2, switcherInt1.getItems().size() );
    assertNull( switcherInt1.getItems().getFirst() );
    assertNull( switcherInt1.getItems().getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, switcherInt2.getItems().size() );
    assertTrue( itemInt1 == switcherInt2.getItems().getFirst() );
    assertTrue( itemInt2 == switcherInt2.getItems().getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   */
  @Test
  public void testSwitchItemsZeroArgsInt()
  {
    // Initialize switchers.
    switcherInt1 = new ItemSwitcher<>();
    switcherInt2 = new ItemSwitcher<>( itemInt1, itemInt2 );

    // Test for empty switcher.
    assertEquals( 2, switcherInt1.switchItems().size() );
    assertNull( switcherInt1.switchItems().getFirst() );
    assertNull( switcherInt1.switchItems().getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, switcherInt2.switchItems().size() );
    assertEquals( switcherInt2.getItemB(),
            switcherInt2.switchItems().getFirst() );
    assertSame( switcherInt2.getItemB(),
            switcherInt2.switchItems().getFirst() );
    assertEquals( switcherInt2.getItemA(),
            switcherInt2.switchItems().getLast() );
    assertSame( switcherInt2.getItemA(),
            switcherInt2.switchItems().getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   */
  @Test
  public void testSwitchItemsObjectObjectInt()
  {
    // Test for half-empty switcher.
    assertEquals( 2, ItemSwitcher.switchItems( itemInt1, null ).size() );
    assertNull( ItemSwitcher.switchItems( itemInt1, null ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( itemInt1, null ).getLast() );
    assertTrue( itemInt1 == ( Integer ) ItemSwitcher.switchItems( itemInt1,
            null ).getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, ItemSwitcher.switchItems( itemInt1, itemInt2 ).size() );
    assertNotNull( ItemSwitcher.switchItems( itemInt1, itemInt2 ).getFirst() );
    assertTrue( itemInt2 == ( Integer ) ItemSwitcher.switchItems( itemInt1,
            itemInt2 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( itemInt1, itemInt2 ).getLast() );
    assertTrue( itemInt1 == ( Integer ) ItemSwitcher.switchItems( itemInt1,
            itemInt2 ).getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If more than two items.
   */
  @Test
  public void testSwitchItemsLinkedListInt()
  {
    // Try on list2.
    assertEquals( 2, listInt2.size() );
    assertEquals( 2, ItemSwitcher.switchItems( listInt2 ).size() );
    assertNotNull( ItemSwitcher.switchItems( listInt2 ).getFirst() );
    assertTrue( itemInt2
            == ( Integer ) ItemSwitcher.switchItems( listInt2 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( listInt2 ).getLast() );
    assertTrue( itemInt1
            == ( Integer ) ItemSwitcher.switchItems( listInt2 ).getLast() );

    // Try on list4.
    assertEquals( 2, listInt4.size() );
    assertEquals( 2, ItemSwitcher.switchItems( listInt4 ).size() );
    assertNotNull( ItemSwitcher.switchItems( listInt4 ).getFirst() );
    assertTrue( itemInt4
            == ( Integer ) ItemSwitcher.switchItems( listInt4 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( listInt4 ).getLast() );
    assertTrue( itemInt3
            == ( Integer ) ItemSwitcher.switchItems( listInt4 ).getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionLessThanTwoInt()
  {
    assertTrue( listInt1.size() < 2 );
    LinkedList<Integer> testList = ItemSwitcher.switchItems( listInt1 );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionLessThanTwo2Int()
  {
    LinkedList<Integer> test = new LinkedList<>();
    assertTrue( test.size() < 2 );
    LinkedList<Integer> testList = ItemSwitcher.switchItems( test );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionMoreThanTwoInt()
  {
    assertTrue( listInt3.size() > 2 );
    LinkedList<Integer> testList = ItemSwitcher.switchItems( listInt3 );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionMoreThanTwo2Int()
  {
    LinkedList<Integer> test = new LinkedList<>();
    test.addAll( listInt1 );
    test.addAll( listInt2 );
    test.addAll( listInt3 );
    test.addAll( listInt4 );
    assertTrue( test.size() > 2 );
    LinkedList<Integer> testList = ItemSwitcher.switchItems( test );
  }

  // Test runs for String objects.
  /**
   * Test of constructor method, of class SwitchItems.
   */
  @Test
  public void testConstructorString()
  {
    // Create empty instance of switcher1.
    switcherString1 = new ItemSwitcher<>();
    // The switcher itself should not be null, but both items.
    assertNotNull( switcherString1 );
    assertNull( switcherString1.getItemA() );
    assertNull( switcherString1.getItemB() );

    // Create empty instance of switcher2.
    switcherString2 = new ItemSwitcher<>();
    // The switcher itself should not be null, but both items.
    assertNotNull( switcherString2 );
    assertNull( switcherString2.getItemA() );
    assertNull( switcherString2.getItemB() );
  }

  /**
   * Test of constructor method, of class SwitchItems.
   */
  @Test
  public void testConstructorTypeTypeString()
  {
    // Create non-empty instance of switcher1.
    switcherString1 = new ItemSwitcher<>( itemString3, itemString4 );
    // The switcher and both items should not be null.
    assertNotNull( switcherString1 );
    assertNotNull( switcherString1.getItemA() );
    assertNotNull( switcherString1.getItemB() );
    // ItemA = item3, ItemB = item4.
    assertEquals( itemString3, switcherString1.getItemA() );
    assertSame( itemString3, switcherString1.getItemA() );
    assertNotSame( itemString1, switcherString1.getItemA() );
    assertNotSame( itemString2, switcherString1.getItemA() );
    assertNotSame( itemString4, switcherString1.getItemA() );
    assertEquals( itemString4, switcherString1.getItemB() );
    assertSame( itemString4, switcherString1.getItemB() );
    assertNotSame( itemString1, switcherString1.getItemB() );
    assertNotSame( itemString2, switcherString1.getItemB() );
    assertNotSame( itemString3, switcherString1.getItemB() );

    // Create non-empty instance of switcher2.
    switcherString2 = new ItemSwitcher<>( itemString1, itemString2 );
    // The switcher and both items should not be null.
    assertNotNull( switcherString2 );
    assertNotNull( switcherString2.getItemA() );
    assertNotNull( switcherString2.getItemB() );
    // ItemA = item1, ItemB = item2.
    assertEquals( itemString1, switcherString2.getItemA() );
    assertSame( itemString1, switcherString2.getItemA() );
    assertNotSame( itemString2, switcherString2.getItemA() );
    assertNotSame( itemString3, switcherString2.getItemA() );
    assertNotSame( itemString4, switcherString2.getItemA() );
    assertEquals( itemString2, switcherString2.getItemB() );
    assertSame( itemString2, switcherString2.getItemB() );
    assertNotSame( itemString1, switcherString2.getItemB() );
    assertNotSame( itemString3, switcherString2.getItemB() );
    assertNotSame( itemString3, switcherString2.getItemB() );
  }

  /**
   * Test of setItemA method, of class SwitchItems.
   */
  @Test
  public void testSetItemAString()
  {
    // Initialize switchers.
    switcherString1 = new ItemSwitcher<>();
    switcherString2 = new ItemSwitcher<>( itemString1, itemString2 );

    // Test for empty switcher.
    assertNull( switcherString1.getItemA() );
    switcherString1.setItemA( itemString1 );
    assertNotNull( switcherString1.getItemA() );
    assertEquals( itemString1, switcherString1.getItemA() );
    assertSame( itemString1, switcherString1.getItemA() );

    // Test for non-empty switcher.
    assertNotNull( switcherString2.getItemA() );
    assertEquals( itemString1, switcherString2.getItemA() );
    assertSame( itemString1, switcherString2.getItemA() );
    switcherString2.setItemA( itemString2 );
    assertFalse( itemString1.equals( itemString2 ) );
    assertNotSame( itemString1, itemString2 );
    assertNotNull( switcherString1.getItemA() );
    assertEquals( itemString2, switcherString2.getItemA() );
    assertSame( itemString2, switcherString2.getItemA() );
  }

  /**
   * Test of setItemB method, of class SwitchItems.
   */
  @Test
  public void testSetItemBString()
  {
    // Initialize switchers.
    switcherString1 = new ItemSwitcher<>();
    switcherString2 = new ItemSwitcher<>( itemString1, itemString2 );

    // Test for empty switcher.
    assertNull( switcherString1.getItemB() );
    switcherString1.setItemB( itemString1 );
    assertNotNull( switcherString1.getItemB() );
    assertEquals( itemString1, switcherString1.getItemB() );
    assertSame( itemString1, switcherString1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcherString2.getItemB() );
    assertEquals( itemString2, switcherString2.getItemB() );
    assertSame( itemString2, switcherString2.getItemB() );
    switcherString2.setItemB( itemString1 );
    assertFalse( itemString1.equals( itemString2 ) );
    assertNotSame( itemString1, itemString2 );
    assertNotNull( switcherString1.getItemB() );
    assertEquals( itemString1, switcherString2.getItemB() );
    assertSame( itemString1, switcherString2.getItemB() );
  }

  /**
   * Test of setItems method, of class SwitchItems.
   */
  @Test
  public void testSetItemsString()
  {
    // Initialize switchers.
    switcherString1 = new ItemSwitcher<>();
    switcherString2 = new ItemSwitcher<>( itemString1, itemString2 );

    // Test for empty switcher.
    assertNull( switcherString1.getItemA() );
    assertNull( switcherString1.getItemB() );
    switcherString1.setItems( itemString1, itemString2 );
    assertNotNull( switcherString1.getItemA() );
    assertEquals( itemString1, switcherString1.getItemA() );
    assertSame( itemString1, switcherString1.getItemA() );
    assertNotNull( switcherString1.getItemB() );
    assertEquals( itemString2, switcherString1.getItemB() );
    assertSame( itemString2, switcherString1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcherString2.getItemA() );
    assertEquals( itemString1, switcherString2.getItemA() );
    assertSame( itemString1, switcherString2.getItemA() );
    assertNotNull( switcherString2.getItemB() );
    assertEquals( itemString2, switcherString2.getItemB() );
    assertSame( itemString2, switcherString2.getItemB() );
    switcherString2.setItems( itemString3, itemString4 );
    assertFalse( itemString1.equals( itemString3 ) );
    assertNotSame( itemString1, itemString3 );
    assertFalse( itemString2.equals( itemString4 ) );
    assertNotSame( itemString2, itemString4 );
    assertNotNull( switcherString2.getItemA() );
    assertEquals( itemString3, switcherString2.getItemA() );
    assertSame( itemString3, switcherString2.getItemA() );
    assertNotNull( switcherString2.getItemB() );
    assertEquals( itemString4, switcherString2.getItemB() );
    assertSame( itemString4, switcherString2.getItemB() );
  }

  /**
   * Test of getItemA method, of class SwitchItems.
   */
  @Test
  public void testGetItemAString()
  {
    // Initialize switchers.
    switcherString1 = new ItemSwitcher<>();
    switcherString2 = new ItemSwitcher<>( itemString1, itemString2 );

    // Test for empty switcher.
    assertNull( switcherString1.getItemA() );

    // Test for non-empty switcher.
    assertNotNull( switcherString2.getItemA() );
    assertEquals( itemString1, switcherString2.getItemA() );
    assertSame( itemString1, switcherString2.getItemA() );
  }

  /**
   * Test of getItemB method, of class SwitchItems.
   */
  @Test
  public void testGetItemBString()
  {
    // Initialize switchers.
    switcherString1 = new ItemSwitcher<>();
    switcherString2 = new ItemSwitcher<>( itemString1, itemString2 );

    // Test for empty switcher.
    assertNull( switcherString1.getItemB() );

    // Test for non-empty switcher.
    assertNotNull( switcherString2.getItemB() );
    assertEquals( itemString2, switcherString2.getItemB() );
    assertSame( itemString2, switcherString2.getItemB() );
  }

  /**
   * Test of getItems method, of class SwitchItems.
   */
  @Test
  public void testGetItemsString()
  {
    // Initialize switchers.
    switcherString1 = new ItemSwitcher<>();
    switcherString2 = new ItemSwitcher<>( itemString1, itemString2 );

    // Test for empty switcher.
    assertEquals( 2, switcherString1.getItems().size() );
    assertNull( switcherString1.getItems().getFirst() );
    assertNull( switcherString1.getItems().getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, switcherString2.getItems().size() );
    assertEquals( itemString1, switcherString2.getItems().getFirst() );
    assertSame( itemString1, switcherString2.getItems().getFirst() );
    assertEquals( itemString2, switcherString2.getItems().getLast() );
    assertSame( itemString2, switcherString2.getItems().getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   */
  @Test
  public void testSwitchItemsZeroArgsString()
  {
    // Initialize switchers.
    switcherString1 = new ItemSwitcher<>();
    switcherString2 = new ItemSwitcher<>( itemString1, itemString2 );

    // Test for empty switcher.
    assertEquals( 2, switcherString1.switchItems().size() );
    assertNull( switcherString1.switchItems().getFirst() );
    assertNull( switcherString1.switchItems().getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, switcherString2.switchItems().size() );
    assertEquals( switcherString2.getItemB(),
            switcherString2.switchItems().getFirst() );
    assertSame( switcherString2.getItemB(),
            switcherString2.switchItems().getFirst() );
    assertEquals( switcherString2.getItemA(),
            switcherString2.switchItems().getLast() );
    assertSame( switcherString2.getItemA(),
            switcherString2.switchItems().getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   */
  @Test
  public void testSwitchItemsObjectObjectString()
  {
    // Test for half-empty switcher.
    assertEquals( 2, ItemSwitcher.switchItems( itemString1, null ).size() );
    assertNull( ItemSwitcher.switchItems( itemString1, null ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( itemString1, null ).getLast() );
    assertEquals( itemString1, ItemSwitcher.switchItems( itemString1,
            null ).getLast() );
    assertSame( itemString1, ItemSwitcher.switchItems( itemString1,
            null ).getLast() );

    // Test for non-empty switcher.
    assertEquals( 2, ItemSwitcher.switchItems( itemString1,
            itemString2 ).size() );
    assertNotNull( ItemSwitcher.switchItems( itemString1,
            itemString2 ).getFirst() );
    assertEquals( itemString2, ItemSwitcher.switchItems( itemString1,
            itemString2 ).getFirst() );
    assertSame( itemString2, ItemSwitcher.switchItems( itemString1,
            itemString2 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( itemString1,
            itemString2 ).getLast() );
    assertEquals( itemString1, ItemSwitcher.switchItems( itemString1,
            itemString2 ).getLast() );
    assertSame( itemString1, ItemSwitcher.switchItems( itemString1,
            itemString2 ).getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If more than two items.
   */
  @Test
  public void testSwitchItemsLinkedListString()
  {
    // Try on list2.
    assertEquals( 2, listString2.size() );
    assertEquals( 2, ItemSwitcher.switchItems( listString2 ).size() );
    assertNotNull( ItemSwitcher.switchItems( listString2 ).getFirst() );
    assertEquals( itemString2,
            ItemSwitcher.switchItems( listString2 ).getFirst() );
    assertSame( itemString2,
            ItemSwitcher.switchItems( listString2 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( listString2 ).getLast() );
    assertEquals( itemString1,
            ItemSwitcher.switchItems( listString2 ).getLast() );
    assertSame( itemString1,
            ItemSwitcher.switchItems( listString2 ).getLast() );

    // Try on list4.
    assertEquals( 2, listString4.size() );
    assertEquals( 2, ItemSwitcher.switchItems( listString4 ).size() );
    assertNotNull( ItemSwitcher.switchItems( listString4 ).getFirst() );
    assertEquals( itemString4,
            ItemSwitcher.switchItems( listString4 ).getFirst() );
    assertSame( itemString4,
            ItemSwitcher.switchItems( listString4 ).getFirst() );
    assertNotNull( ItemSwitcher.switchItems( listString4 ).getLast() );
    assertEquals( itemString3,
            ItemSwitcher.switchItems( listString4 ).getLast() );
    assertSame( itemString3,
            ItemSwitcher.switchItems( listString4 ).getLast() );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionLessThanTwoString()
  {
    assertTrue( listString1.size() < 2 );
    LinkedList<String> testList = ItemSwitcher.switchItems( listString1 );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionLessThanTwo2String()
  {
    LinkedList<String> test = new LinkedList<>();
    assertTrue( test.size() < 2 );
    LinkedList<String> testList = ItemSwitcher.switchItems( test );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionMoreThanTwoString()
  {
    assertTrue( listString3.size() > 2 );
    LinkedList<String> testList = ItemSwitcher.switchItems( listString3 );
  }

  /**
   * Test of switchItems method, of class SwitchItems.
   *
   * @throws IllegalArgumentException If not equal two items.
   */
  @Test( expected = IllegalArgumentException.class )
  public void testSwitchItemsLinkedListExceptionMoreThanTwo2String()
  {
    LinkedList<String> test = new LinkedList<>();
    test.addAll( listString1 );
    test.addAll( listString2 );
    test.addAll( listString3 );
    test.addAll( listString4 );
    assertTrue( test.size() > 2 );
    LinkedList<String> testList = ItemSwitcher.switchItems( test );
  }
}
