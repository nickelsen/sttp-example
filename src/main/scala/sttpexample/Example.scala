package sttpexample

import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend
import sttp.client3.httpclient.zio.HttpClientZioBackend
import sttp.client3.{UriContext, basicRequest}
import zio.{ZIO, ZIOAppDefault}

object Example extends ZIOAppDefault {
  val address = "Rentemestervej 8, 2400 København NV"

  val request = basicRequest.get(
    uri"https://dawa.aws.dk/autocomplete?q=${address}"
  )

  // This works
  val asyncHttpClientZioBackend = AsyncHttpClientZioBackend().flatMap(request.send(_)).flatMap(resp => ZIO.logInfo(resp.toString)).orDie

  // This throws IOException("no statuscode in response")
  val httpClientZioBackend = HttpClientZioBackend().flatMap(request.send(_)).flatMap(resp => ZIO.logInfo(resp.toString)).orDie

  override def run = asyncHttpClientZioBackend *> httpClientZioBackend
}
