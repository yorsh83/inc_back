package com.att.service;

import java.util.List;

public interface ICRUD<T> {

	T agregar(T t);

	T modificar(T t);

	void eliminar(int id);

	T listarId(int id);

	List<T> listarTodo();

}
