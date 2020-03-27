package com.aquitraslomita.venice.repro;

import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerMyComponent implements MyComponent {
  private DaggerMyComponent() {

  }

  public static Builder builder() {
    return new Builder();
  }

  public static MyComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public MyComponent build() {
      return new DaggerMyComponent();
    }
  }
}
