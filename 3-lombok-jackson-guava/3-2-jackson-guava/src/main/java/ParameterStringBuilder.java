import static java.util.stream.Collectors.toList;

import com.google.common.base.Joiner;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ParameterStringBuilder {

  public static String getParamsString(Map<String, String> parameters) {
    List<String> queries = parameters.entrySet().stream()
        .map(ParameterStringBuilder::encodeParam)
        .collect(toList());

    return Joiner.on("&").join(queries);
  }

  private static String encodeParam(Entry<String, String> parameter) {
    return Joiner.on("=").join(urlEncode(parameter.getKey()), urlEncode(parameter.getValue()));
  }

  private static String urlEncode(String queryPart) {
    try {
      return URLEncoder.encode(queryPart, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
