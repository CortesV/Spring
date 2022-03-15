package com.devcortes.springbuilder;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    private Map<String, String> properties;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        this.properties = new BufferedReader(new FileReader(path))
                .lines()
                .map(line -> line.split(" = "))
                .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
    }

    @SneakyThrows
    @Override
    public void configure(Object t, ApplicationContext context) {
        for (Field declaredField : t.getClass().getDeclaredFields()) {
            Optional<InjectProperty> annotation = Optional.ofNullable(declaredField.getAnnotation(InjectProperty.class));

            if (annotation.isPresent()) {
                String value = annotation.get().value().isEmpty() ? properties.get(declaredField.getName()) : properties.get(annotation.get().value());
                declaredField.setAccessible(true);
                declaredField.set(t, value);
            }
        }
    }
}
