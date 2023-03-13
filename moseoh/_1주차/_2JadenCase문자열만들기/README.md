# Java의 Split vs Kotlin의 Split

아래와 같은 문자열이 제공되었을 때,

> `"3people unFollowed me  asd  "`

Stream을 사용하여 동일하게 작성하였으나 결과가 달랐다.

### Java

```java
public class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split(" ")).map(it -> capitalize(it)).collect(Collectors.joining(" "));
    }
}
```

결과: `"3people Unfollowed Me  Asd"`

### Kotlin

```kotlin
class Solution {
    fun solution(s: String): String =
        s.split(" ").joinToString(" ") { it.lowercase().replaceFirstChar { c -> c.titlecase() } }
}
```

결과: `"3people Unfollowed Me  Asd  "`

Kotlin에서의 split은 delim을 받지만 Java에서의 split은 regex로 받는 것.

Kotlin의 delim처럼 동작하도록 StringTokenizer를 활용하여 해결.

