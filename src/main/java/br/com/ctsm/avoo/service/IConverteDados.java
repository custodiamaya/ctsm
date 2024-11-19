package br.com.ctsm.avoo.service;

public interface IConverteDados {
    <T> T obterDados (String json, Class<T> classe);
}
