public class Gap {
    static char []buffer = new char[50];
    static int gap_size = 10;
    static int gap_left = 0;
    static int gap_right = gap_size - gap_left - 1;
    static int size = 10;

    static void grow(int k, int position)
    {
        char []a = new char[size];
        //aici se creeaza un nou vector cu elementele deja existente in buffer incepand cu pozitia data
        int index=0;
        for (int i = position; i < size; i++)
        {
            a[index] = buffer[i];
            index++;
        }
        // in buffer-ul vechi se pune peste valorile sale precedente, '_' pentru a nu se suprapune noua valoare ce va fi introdusa
        // cu cea care momentan este stocata ain a[]
        // si seteaza toate valorile pana la 10 + pozitia cautata, pentru a avea 10 spatii noi incepand de la positie
        for (int i = position; i < k + position; i++)
        {
            buffer[i] = '_';
        }

        // se repun vechiile valori ce au fost stocate in a[] precedent, dar incepand de la valoare pozitiei
        // adunat cu 10, care sunt spatiile nou create
        for (int i = 0; i < k; i++)
        {
            buffer[position + k + i] = a[i];
        }
        //la size si gap_right se aduna inca un 10 in cazul de fata, adica noile valori
        size += k;
        gap_right += k;
    }

    //
    static void left(int i)
    {

        while (i < gap_left)
        {
            gap_left--;
            gap_right--;
            buffer[gap_right + 1] = buffer[gap_left];
            buffer[gap_left]='_';
        }
    }


    static void right(int i)
    {
        //daca pozitia este mai mare decat indexul de gap de dreapta muta toate valorile spre dreapta si cele din buffer
        while (i > gap_left)
        {
            gap_left++;
            gap_right++;
            buffer[gap_left - 1] = buffer[gap_right];
            buffer[gap_right]='_';
        }
    }

    // alege daca va trebui sa se mute gap-ul spre stanga sau spre dreapta
    static void move_cursor(int position)
    {
        if (position < gap_left)
            left(position);
        else
            right(position);
    }

    static void insert(String input, int position)
    {
        int len = input.length();
        int i = 0;
        // verifica sa inceapa cursorul de la valoarea specificata
        if (position != gap_left)
        {
            move_cursor(position);
        }

        while (i < len)
        {
            // pentru fiecare caracter nou introdus se verifica daca este spatiu suficient pentru a putea fi introdus
            // daca nu se apeleaza functia grow ce introduce k spatii noi in buffer
            if (gap_right == gap_left)
            {
                int k = 10;
                grow(k, position);
            }
            //altfel daca este spatiu se insereaza caracter cu caracter si este incrementat limita de stanga
            buffer[gap_left] = input.charAt(i);
            gap_left++;
            i++;
            position++;
        }
    }

    public static void main(String[] args)
    {

        for (int i = 0; i < 10; i++)
        {
            buffer[i] = '_';
        }
        insert("Anca", 0);

        for(int i= 0; i<size ;i++)
        {
            System.out.print(buffer[i] + " ");
        }

        insert("Dreghiciu", 5);

        System.out.println();
        for(int i= 0; i<size; i++)
        {
            System.out.print(buffer[i] + " ");
        }

        insert("Mad", 4);
        System.out.println();
        for(int i= 0; i<size; i++)
        {
            System.out.print(buffer[i] + " ");
        }

        insert("alina", 10);
        System.out.println();
        for(int i= 0; i<size; i++)
        {
            System.out.print(buffer[i] + " ");
        }

    }


}

