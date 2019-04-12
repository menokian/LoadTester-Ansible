package devLoadTesting

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoadTestingDevBrowseSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("https://google.com")
		.inferHtmlResources(WhiteList(), BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png""", """.*\.svg""", """.*\.cur"""))
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:51.0) Gecko/20100101 Firefox/51.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Accept" -> "*/*")

    val uri1 = "https://www.LoadTesting.com/media"
    val uri2 = "dev.LoadTesting.com"

	val scn = scenario("LoadTestingDevBrowseSimulation")
		.exec(http("HomePage")
			.get("https://" + uri2 + ":443/")
			.headers(headers_0))
		.pause(1)
		.exec(http("NR1")
			.get("/1/88587edab0?a=17207405&v=1016.8b58850&to=NAZTY0JZDxdQV0xQVg1McFREUQ4KHldVShYKDVVSSBcIClVRQA%3D%3D&rst=539661&ref=https://dev.LoadTesting.com/&ap=586&be=538521&fe=692&dc=608&perf=%7B%22timing%22:%7B%22of%22:1486585473734,%22n%22:0,%22u%22:538487,%22ue%22:538487,%22f%22:537597,%22dn%22:537597,%22dne%22:537597,%22c%22:537597,%22ce%22:537597,%22rq%22:537788,%22rp%22:537782,%22rpe%22:538484,%22dl%22:2,%22di%22:42,%22ds%22:58,%22de%22:58,%22dc%22:539212,%22l%22:539212,%22le%22:539227%7D,%22navigation%22:%7B%7D%7D&at=GEFQFQpDHBk%3D&jsonp=NREUM.setToken")
			.headers(headers_1)
			.resources(http("site_category")
			.get("https://" + uri2 + ":443/men/site.html")
			.headers(headers_0),
            http("NR2")
			.get("/1/88587edab0?a=17207405&v=1016.8b58850&to=NAZTY0JZDxdQV0xQVg1McFREUQ4KHldZTVgPDFYYU1kVAVZbSkAWFQpUQA%3D%3D&rst=1728&ref=https://dev.LoadTesting.com/men/site.html&ap=988&be=1215&fe=454&dc=413&perf=%7B%22timing%22:%7B%22of%22:1486586014537,%22n%22:0,%22u%22:1172,%22ue%22:1173,%22f%22:7,%22dn%22:7,%22dne%22:7,%22c%22:7,%22ce%22:7,%22rq%22:7,%22rp%22:1167,%22rpe%22:1168,%22dl%22:1172,%22di%22:1594,%22ds%22:1627,%22de%22:1643,%22dc%22:1668,%22l%22:1668,%22le%22:1670%7D,%22navigation%22:%7B%7D%7D&at=GEFQFQpDHBk%3D&jsonp=NREUM.setToken")
			.headers(headers_1)))
		.pause(1)
		.exec(http("product1")
			.get("https://" + uri2 + ":443/men/site.html")
			.headers(headers_0))
		.pause(1)
		.exec(http("NR3")
			.get("/1/88587edab0?a=17207405&v=1016.8b58850&to=NAZTY0JZDxdQV0xQVg1McFREUQ4KHldZTVgPDFYYQEoOAERXTBZPCgZG&rst=32759&ref=https://dev.LoadTesting.com/men/site/blue-white.html&ap=31403&be=31631&fe=1082&dc=413&perf=%7B%22timing%22:%7B%22of%22:1486586018028,%22n%22:0,%22u%22:31593,%22ue%22:31595,%22f%22:3,%22dn%22:3,%22dne%22:3,%22c%22:3,%22ce%22:3,%22rq%22:4,%22rp%22:31591,%22rpe%22:31591,%22dl%22:31593,%22di%22:32018,%22ds%22:32043,%22de%22:32507,%22dc%22:32712,%22l%22:32712,%22le%22:32715%7D,%22navigation%22:%7B%7D%7D&at=GEFQFQpDHBk%3D&jsonp=NREUM.setToken")
			.headers(headers_1))
		.pause(1)
		.exec(http("product2")
			.get("https://" + uri2 + ":443/men/site/white.html")
			.headers(headers_0))
		.pause(2)
		.exec(http("NR4")
			.get("/1/88587edab0?a=17207405&v=1016.8b58850&to=NAZTY0JZDxdQV0xQVg1McFREUQ4KHkRZXlwAAlJfVRcTAUBBXUpNTBNDWFNdEhc%3D&rst=33002&ref=https://dev.LoadTesting.com/men/site/green-white.html&ap=30770&be=31012&fe=1884&dc=1092&perf=%7B%22timing%22:%7B%22of%22:1486586063113,%22n%22:0,%22u%22:30974,%22ue%22:30976,%22f%22:4,%22dn%22:4,%22dne%22:4,%22c%22:4,%22ce%22:4,%22rq%22:4,%22rp%22:30972,%22rpe%22:30972,%22dl%22:30974,%22di%22:32060,%22ds%22:32103,%22de%22:32747,%22dc%22:32895,%22l%22:32895,%22le%22:32901%7D,%22navigation%22:%7B%22ty%22:1%7D%7D&at=GEFQFQpDHBk%3D&jsonp=NREUM.setToken")
			.headers(headers_1))

	setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}
