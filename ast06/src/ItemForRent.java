//*******************************************************************
//  ItemForRent.java                      Author:  Wayne Cutcliffe
//
//  Prototype: Represents a piece of hardware equipment for rent.
//*******************************************************************

import hashTable.KeyedItem;


public class ItemForRent extends KeyedItem<Integer>
{
 	private String 	itemName = "**hidden**";
  	private double	hourlyRate = 0.0;
  	private boolean valid = true;
  	private boolean available = true;

		// contructors

   public ItemForRent (int id, String name,  double rate)
   {
      super(id);
      itemName = name;
      hourlyRate = rate;
   }

   public ItemForRent (Integer id)
   {
      super(id);
   }

  	//  Accessor methods for item data
   	//-----------------------------------------------------------------

//	inherits:  public int getKey ()

	public String getName ()
   	{  	return itemName;   	}

	public double getHourlyRate ()
   	{  	return hourlyRate;  }

 	//	Check status of item
   	public boolean isAvailable ()
   	{  	return available;  }

	public boolean isValidItem ()
   	{  	return valid;  }

   //-----------------------------------------------------------------
   //  	Compares my "key" field with another rental item.
   //  	Returns -1, 0, or 1 for less than, equal to, or greater than.
   //-----------------------------------------------------------------
   public int compareTo (Object other)
   {
   	  ItemForRent card = (ItemForRent) other;
      if (getKey() < card.getKey())
          return -1;
      else
        if (getKey() == card.getKey())
           return 0;
        else
           return 1;
   }

   	//-----------------------------------------------------------------
   	//	Override Object methods: hashCode(), equals(Object), toString()
    //-----------------------------------------------------------------
  	public int hashCode()
   	{
     	// write code
   	}

    public boolean equals(Object other)
    {
     	// write code
    }

    //	Returns the name of the item.

    public String toString()
    {
     	// write code
    }
}	// ItemForRent class
