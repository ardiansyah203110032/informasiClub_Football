package com.ardiansyahmnur.informasiclub_football

object ClubsData {
    object ApiEndpoint {
    var BASEURL = "https://football.com/search?q={query}"
    fun sendGet() {
    val url = URL("https://www.google.com/search?gs_ssp=eJzj4tDP1Tcwii9JNmD0Es7OKU1SKChKzc1MLVLISU1ML00FAJg0Clk&q=klub+premier+league&rlz=1C1GCEU_en-GBID945ID945&oq=club+preme&aqs=chrome.1.69i57j46i10i13i512j0i10i13i512l3j0i13i30l4.4847j0j7&sourceid=chrome&ie=UTF-8")

    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET

        println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

        inputStream.bufferedReader().use {
            it.lines().forEach { line ->
                println(line)
            }
    private val clubNames = arrayOf("Arsenal",
        "Aston Vila",
        "Chelsea",
        "Leicester City",
        "Liverpool",
        "Manchester United",
        "Manchester City",
        "Newcastle United",
        "Tottenham Hotspur",
        "West Ham United"
    )

    private  val clubStadium = arrayOf("Emirates",
        "Villa Park",
        "Stamford Bridge",
        "King Power Stadium",
        "Anfield",
        "Old Trafford",
        "Etihad Stadium",
        "St. James' Park",
        "Tottenham Hotspur Stadium",
        "London Stadium")

    private  val clubDetails = arrayOf("Arsenal Football Club, commonly referred to as Arsenal, is a professional football club based in Islington, London, England. Arsenal plays in the Premier League, the top flight of English football.",
        "Aston Villa Football Club is a professional football club based in Aston, Birmingham, England. The club competes in the Premier League, the top tier of the English football league system. Founded in 1874, they have played at their home ground, Villa Park, since 1897",
        "Chelsea Football Club is an English professional football club based in Fulham, West London. Founded in 1905, they play their home games at Stamford Bridge. The club competes in the Premier League, the top division of English football. They won their first major honour, the League championship, in 1955.",
        "Leicester City Football Club is an English professional football club based in Leicester in the East Midlands of England. The club competes in the Premier League, the highest level of England's football league system, and plays its home matches at King Power Stadium",
        "Liverpool Football Club is a professional football club based in Liverpool, England. The club competes in the Premier League, the top tier of English football. Founded in 1892, the club joined the Football League the following year and has played its home games at Anfield since its formation",
        "Manchester United Football Club, commonly referred to as Man United, or simply United, is a professional football club based in Old Trafford, Greater Manchester, England. The club competes in the Premier League, the top division in the English football league system.",
        "Manchester City Football Club are an English football club based in Manchester that competes in the Premier League, the top flight of English football. Founded in 1880 as St. Mark's, they became Ardwick Association Football Club in 1887 and Manchester City in 1894.",
        "Newcastle United Football Club is an English professional football club, based in Newcastle upon Tyne, that plays in the Premier League – the top flight of English football. The club was founded in 1892 by the merger of Newcastle East End and Newcastle West End",
        "Tottenham Hotspur Football Club, commonly referred to as Tottenham or Spurs, is a professional football club based in Tottenham, London, England. It competes in the Premier League, the top flight of English football",
        "West Ham United Football Club is an English professional football club that plays its home matches in Stratford, East London. The club competes in the Premier League, the top tier of English football. The club plays at the London Stadium, having moved from their former home, the Boleyn Ground, in 2016")

    private val clubImages = intArrayOf(R.drawable.arsenal,
        R.drawable.aston_vila,
        R.drawable.chelsea,
        R.drawable.leceister,
        R.drawable.liverpool,
        R.drawable.manchester_united,
        R.drawable.manchester_city,
        R.drawable.newcastle,
        R.drawable.toteham,
        R.drawable.westham
    )

    val listData : ArrayList<Club>
        get() {
            val list = arrayListOf<Club>()
            for (position in clubNames.indices){
                val club = Club()
                club.name = clubNames[position]
                club.stadium = clubStadium[position]
                club.detail = clubDetails[position]
                club.photo = clubImages[position]
                list.add(club)
            }
            return  list
        }

}

//pada kode tersebut memberikan input data yang akan ditampilkan enentukan implementasi 
//PagingSource untuk mengidentifikasi sumber data. Class API PagingSource mencakup metode load(), 
//yang harus Anda ganti untuk menunjukkan cara mengambil data yang di-page dari sumber data yang sesuai
//Implementasi PagingSource juga harus menerapkan metode getRefreshKey() yang membutuhkan objek PagingState 
//sebagai parameter dan mengembalikan kunci untuk diteruskan ke metode load() saat data di-refresh atau tidak valid setelah pemuatan awal.
