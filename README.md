# Jalt

Java algorithm library with tutorials.

## Short tutorials

- Chapter 1. [Collections](docs/01-collections.md)
- Chapter 2. [Complexity](docs/02-complexity.md)
- Chapter 3. [Basic sort and search](docs/03-basic-sort-and-search.md)

## Algorithms

See [ALGORITHMS.md](ALGORITHMS.md).

## How to use source codes

### Building

You can build java files using `makefile` as below:

```
$ make build
```

or, using a wrapper bash script:

```
$ ./build.sh
```

### Testing

You can use a wrapper bash script for testing.
For example, to test `ArrayStack.class` with `data/loremShort.txt` as input, run:

```
$ ./test.sh ArrayStack loremShort.txt
```

## References

- Algorithms (4th ed., Robert Sedgewick and Kevin Wayne)
- Introduction to Algorithms (3rd ed., Thomas Cormen et al.)
- Guide to Competitive Programming (2nd ed., Antti Laaksonen)
