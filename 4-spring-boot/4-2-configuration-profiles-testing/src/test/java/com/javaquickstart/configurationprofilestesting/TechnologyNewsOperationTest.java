package com.javaquickstart.configurationprofilestesting;

import static com.google.common.base.Charsets.UTF_8;
import static okhttp3.Protocol.HTTP_1_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import com.google.common.io.Resources;
import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("mocked-client")
@SpringBootTest(webEnvironment = NONE)
@TestPropertySource(properties = "management.server.port=0")
public class TechnologyNewsOperationTest {

  @Autowired
  private GuardianNewsClient guardianNewsClient;

  @Autowired
  private TechnologyNewsOperation underTest;

  @Test
  public void shouldReturnTechnologyHeadlinesAsList() throws IOException {
    given(guardianNewsClient.fetchTechnologyNews()).willReturn(new Response.Builder()
        .protocol(HTTP_1_1)
        .code(200)
        .message("foo")
        .request(new Request.Builder()
            .url("http://mockUrl.com")
            .build())
        .body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"),
            Resources.toString(
            Resources.getResource("expectedGuardianApiResponse.json"), UTF_8
            )
        ))
        .build());

    final List<String> headlines = underTest.getTechnologyHeadlines();

    assertThat(headlines).containsExactly(
        "What's the best laptop for university under £600?",
        "Google Home Max review: bigger and smarter sound", "Franken-algorithms: the deadly consequences of unpredictable code",
        "Dyson to expand Wiltshire facility to boost electric-car tests",
        "Twitch: what is the platform that livestreamed the Florida shooting?",
        "Elon Musk doubles down on 'pedo' claims against UK cave diver",
        "Natural Cycles app: 'highly accurate contraceptive' claim misled consumers",
        "‘Digital shackles’: the unexpected cruelty of ankle monitors",
        "Driverless taxi debuts in Tokyo in 'world first' trial ahead of Olympics",
        "‘Reattaching for convenience’: nine passive-aggressive email phrases that must end now"
        );
  }

}
