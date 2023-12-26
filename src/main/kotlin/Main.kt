data class movie(val name: String, val genre: String, val director: String, val year: Int)


class movieCollection {

    private val movies: MutableList<movie> = mutableListOf()

    fun addMovie(movie: movie) {
        movies.add(movie)
    }

    fun searchMoviesByDirector(director: String): List<movie> {
        return movies.filter { it.director == director }
    }

    fun searchMoviesByGenre(genre: String): List<movie> {
        return movies.filter { it.genre == genre }
    }

    fun searchMoviesByName(name: String): List<movie> {
        return movies.filter { it.name == name }
    }

    fun searchMoviesByYear(year: Int): List<movie> {
        return movies.filter { it.year == year }
    }

    fun showAllMovies() {
        println("\n=== All Movies ===")
        movies.forEach { println(it) }
    }


    fun addNewMovie() {
        println("Enter the details for the new movie:")
        print("Name: ")
        val name = readLine() ?: ""
        print("Genre: ")
        val genre = readLine() ?: ""
        print("Director: ")
        val director = readLine() ?: ""
        print("Year: ")
        val year = readLine()?.toIntOrNull() ?: 0

        val newMovie = movie(name, genre, director, year)
        addMovie(newMovie)
        println("New movie added successfully!")
    }


    fun menu() {
        var continueMenu = true

        do {
            println("\n=== Movie Collection Menu ===")
            println("1. Add a new movie")
            println("2. Search movies by director")
            println("3. Search movies by genre")
            println("4. Search movies by name")
            println("5. Search movies by year")
            println("6. Show all movies")
            println("7. Exit")
            print("Enter your choice (1-7): ")

            val choice = readlnOrNull()?.toIntOrNull() ?: 0

            when (choice) {
                1 -> addNewMovie()

                2 -> {
                    print("Enter director to search: ")
                    val director = readLine() ?: ""
                    searchMoviesByDirector(director)
                    val results = searchMoviesByDirector(director)
                    printSearchResults(results)
                }

                3 -> {
                    print("Enter genre to search: ")
                    val genre = readLine() ?: ""
                    searchMoviesByGenre(genre)
                    val results = searchMoviesByGenre(genre)
                    printSearchResults(results)
                }

                4 -> {
                    print("Enter name to search: ")
                    val name = readLine() ?: ""
                    searchMoviesByName(name)
                    val results = searchMoviesByName(name)
                    printSearchResults(results)
                }

                5 -> {
                    print("Enter year to search: ")
                    val year = readLine()?.toIntOrNull() ?: 0
                    val results = searchMoviesByYear(year)
                    printSearchResults(results)

                }

                6 -> showAllMovies()
                7 -> {
                    println("Exiting. Goodbye!")
                    continueMenu = false
                }

                else -> println("Invalid choice. Please enter a number between 1 and 7.")
            }
        } while (continueMenu)
    }

    private fun printSearchResults(results: List<movie>){
        if(results.isNotEmpty()){
            println("\n===== Search Results ===")
            results.forEach { println(it) }

        } else {
            println()
            println("======No movies found======")
        }
    }
}



    fun main() {

        val movie1 = movie( " Interstellar",  " Science Fiction",  " Christopher Nolan",  2014)
        val movie2 = movie( " Inception",  " Action, Science Fiction",  " Christopher Nolan",  2010)
        val movie3 = movie( " Fight Club",  " Drama",  " David Fincher",  1999)
        val movie4 = movie( " Whiplash",  " Drama, Music",  " Damien Chazelle",  2014)
        val movie5 = movie( " The Godfather",  " Crime, Drama ",  " Francis Ford Coppola",  1972)
        val movie6 = movie( " Spirited Away",  " Animation, Adventure",  " Hayao Miyazaki",  2001)

        val movieCollection = movieCollection()

        movieCollection.addMovie(movie1)
        movieCollection.addMovie(movie2)
        movieCollection.addMovie(movie3)
        movieCollection.addMovie(movie4)
        movieCollection.addMovie(movie5)
        movieCollection.addMovie(movie6)

        movieCollection.menu()


    }
