# /******************************************************************************
 *  Name: Gordon Portzline
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name: Jack Scothorne
 *  Partner NetID:    
 *  Partner Precept:  
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 2: Deques and Randomized Queues


/******************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 J+  *****************************************************************************/
I implemented the Randomized Queue with a resizing array-backed type. I think it made for a very simple Iterator implementation
where it was easy to pull a random index utilizing the StdRandom library. I was nervous because the resizing array may not be
considered the most performant data type. However, I believe that all my operations conform to the constant amortized time
requirement because all operations are constant unless the array must resize in which case it still would be considered
amortized time since you must consider the summation of operations and not just a worst-case sample. I am also of the opinion
that my array conforms to all other requirements given that "use space proportional to the number of items currently in the queue"
is general enough language to allow an array where space allocated is 2N but space actually used is N. Again, I think having
an array field made implementing my Iterator very easy with all requirements considered.

/******************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 *****************************************************************************/

Randomized Queue:   ~  2.25N (array in the worst-case) + 16 (object overhead) + 12 (3 integer fields) bytes

Deque:               ~   16 (deque obj)	+ 16 * n (each node object)	+ 16 * n (8 for each reference, forward and back) bytes




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
There's a bug in Subset where if the number of Strings in the buffer is less than the integer argument to main
then the program hangs indefinitely. However, I think this defect is sort of 'covered' in the sense that the
requirements mention "You may assume that 0 ≤ k ≤ N, where N is the number of string on standard input".

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/

 Just Jack Scothorne and myself.

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/

I believe we followed protocol and collaborated amongst ourselves. Jack wrote the Deque class and I wrote
Subset and RandomizedQueue.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/

We encountered some confusion when implementing an Iterator in the linked list Deque class.

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
