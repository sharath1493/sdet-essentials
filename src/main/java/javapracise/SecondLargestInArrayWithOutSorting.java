package javapracise;

public class SecondLargestInArrayWithOutSorting {

	public static void main(String[] args) {

		int[] a = {5,67,34,9,35,56,33,45,35,91,91};

		int max=a[0];
		int second=a[0];

		if(a.length < 2)
		{
			System.out.println("Array size is than 2. Cant find 2nd Max number");
		}
		else
		{
			for(int i=0; i<a.length; i++)
			{
				if(a[i] > max)
				{
					second=max;
					max=a[i];
				}
				else if(a[i] > second & max > a[i])
				{
					second = a[i];
				}
			}
		}


		System.out.println(second);
	}

}
