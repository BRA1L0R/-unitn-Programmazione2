# Generics in other programming languages
Generics allow programmers to write code that works with different data types while maintaining Type Safety.
However, different languages implement this concept in radically different ways.
**Java** used its Type Erasure for backwards compatability rteasons. Generics were added in 2004, millions of lines of Java already existed.
The new generic feature was nto allowed to add new JVM instructions to the langauge.
One advantage is that ArrayList<String> and ArrayList<Integer> share the exact same code.
Since Java has a seperation between primitive types like `int` and objects, we cannot write ArrayList<int>.
We ahve to use the class Integer which induces a memory overhead. Again tihis is becasue of erasure because `int` is not
an object
## C++
C++ uses templates to implement generics.
The compiler will generate two completly different copies of the vector class in machine code.
This process is called monomorphization.
This is doen because of the heave focus on performance for C++ people. C++ prioritzes zero-overhead abstractions.
By generating specific code for each type, the compiler can do more optimizations since the types are known.
One disadvantage is that the binary size can increase a lot, it increases compile times y a lot and error messages of templates
were horroful.
Rust does something similar.
## C#
Micrsoft learned from javas generics and saw the limitations caused by type erasure. Genreics were baked into the runtime
of the language
You can do typeof(T), new T(), and reflection works perfectly.
Of course this made the runtime way more complex and it broke backwards compabality at that point.
C# runtime creates specialized types on the fly when the program runs.