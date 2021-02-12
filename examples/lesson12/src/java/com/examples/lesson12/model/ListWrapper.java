package com.examples.lesson12.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListWrapper<T> implements Iterable<T> {

  protected List<T> wrappedList;

  public ListWrapper() {
    wrappedList = new ArrayList<T>();
  }

  public ListWrapper(List<T> wrappedList) {
    this.wrappedList = wrappedList;
  }

  @Override
  public Iterator<T> iterator() {
    return wrappedList.iterator();
  }

//  @Override
  public boolean add(T e) {
    return wrappedList.add(e);
  }

//  @Override
  public T get(int index) {
    return wrappedList.get(index);
  }
//
//  @Override
//  public int size() {
//    return wrappedList.size();
//  }
//
//  @Override
//  public boolean isEmpty() {
//    return wrappedList.isEmpty();
//  }
//
//  @Override
//  public boolean contains(Object o) {
//    return wrappedList.contains(o);
//  }
//
//  @Override
//  public Object[] toArray() {
//    return wrappedList.toArray();
//  }
//
//  @Override
//  public <T> T[] toArray(T[] a) {
//    return wrappedList.toArray(a);
//  }
//
//  @Override
//  public boolean remove(Object o) {
//    return wrappedList.remove(o);
//  }
//
//  @Override
//  public boolean containsAll(Collection<?> c) {
//    return wrappedList.containsAll(c);
//  }
//
//  @Override
//  public boolean addAll(Collection<? extends T> c) {
//    return wrappedList.addAll(c);
//  }
//
//  @Override
//  public boolean addAll(int index, Collection<? extends T> c) {
//    return wrappedList.addAll(index, c);
//  }
//
//  @Override
//  public boolean removeAll(Collection<?> c) {
//    return wrappedList.removeAll(c);
//  }
//
//  @Override
//  public boolean retainAll(Collection<?> c) {
//    return wrappedList.retainAll(c);
//  }
//
//  @Override
//  public void clear() {
//    wrappedList.clear();
//  }
//
//  @Override
//  public T set(int index, T element) {
//    return wrappedList.set(index, element);
//  }
//
//  @Override
//  public void add(int index, T element) {
//    wrappedList.add(index, element);
//  }
//
//  @Override
//  public T remove(int index) {
//    return wrappedList.remove(index);
//  }
//
//  @Override
//  public int indexOf(Object o) {
//    return wrappedList.indexOf(o);
//  }
//
//  @Override
//  public int lastIndexOf(Object o) {
//    return wrappedList.lastIndexOf(o);
//  }
//
//  @Override
//  public ListIterator<T> listIterator() {
//    return wrappedList.listIterator();
//  }
//
//  @Override
//  public ListIterator<T> listIterator(int index) {
//    return wrappedList.listIterator(index);
//  }
//
//  @Override
//  public List<T> subList(int fromIndex, int toIndex) {
//    return wrappedList.subList(fromIndex, toIndex);
//  }
}
