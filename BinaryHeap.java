import java.util.Arrays;

public class BinaryHeap 
{
	
		private int items[];
		private int size;
		
		
		public BinaryHeap()
		{
			items = new int[10];
			size = 0;
		}
	

	public void add(int i) 
	{
		// TODO Auto-generated method stub
		if(size>= items.length)
		{
			items = Arrays.copyOf(items, items.length*2);
		}
		items[size++] = i;
		
		int curr = size-1;
		int top =  (curr-1)/2;
		
		
		while((items[curr] < items[top]))
		{
			
			swap(items, curr, top);
			curr = top;
			top = (top-1)/2;
			
		}
	}

	private void swap(int[] items, int a, int b) 
	{
		// TODO Auto-generated method stub
		int temp = items[a];
		items[a] = items[b];
		items[b] = temp;
		
	}


	public int remove() 
{
		// TODO Auto-generated method stub
		try
	{
		assert size > 0;
		swap(items,size-1,0);
		size--;
		if(size!= 0)
		{
			shiftDown(0);
		}
	}
		
		catch(Exception e)
		{
			System.out.print("No Items Anymore");
		}
		return items[size];
	}


	private void shiftDown(int i) 
	{
		// TODO Auto-generated method stub
		int smallest;
		while(!isLeaf(i))
		{
			smallest = ((i*2)+1);
			if(items[smallest] > items[smallest+1] && ((smallest+ 1)< size))
			{
				smallest++;
			}
			if(items[i] <= items[smallest])
			{
				return;
			}
			swap(items,i,smallest);
			i = smallest;
			
		}
		
	}


	private boolean isLeaf(int i) 
	{
		// TODO Auto-generated method stub
		
		return ((i < size) && (i >= (size / 2)));
		
	}

}
