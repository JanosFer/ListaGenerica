package model;

public class ListaEncadeada<T> implements ILista<T>{
	
	No<T> primeiro;

	public ListaEncadeada(){
		primeiro = null;
	}
	
	@Override
	public boolean isEmpty() {
		if(primeiro == null) {
			return true;
		}
		return false;
	}

	@Override
	public void addFirst(T valor) {
		No<T> elemento = new No<T>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	@Override
	public void addLast(T valor) throws Exception {
		if(isEmpty()) {
			//throw new Exception("Lista Vazia");
			addFirst(valor);
		} else {
			int tamanho = size();
			No<T> elemento = new No<T>();
			elemento.dado = valor;
			elemento.proximo = null;
			No<T> ultimo = getNo(tamanho-1);
			ultimo.proximo = elemento;
		}
	}

	@Override
	public void add(T valor, int posicao) throws Exception {
		int tamanho = size();
		if(posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição Inválida");
		}
		if(posicao == 0) {
			addFirst(valor);
		}else if(posicao == tamanho){
			addLast(valor);
		}else {
			No<T> elemento = new No<T>();
			elemento.dado = valor;
			No<T> anterior = getNo(posicao - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}

	@Override
	public void removeFirst() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		
		primeiro = primeiro.proximo;
	}

	@Override
	public void removeLast() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		
		if(tamanho == 1) {
			removeFirst();
		}else {
			No<T> penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
	}

	@Override
	public void remove(int posicao) throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if(posicao < 0 || posicao > tamanho - 1) {
			throw new Exception("Posição Inválida");
		}
		if(posicao == 0) {
			removeFirst();;
		}else if(posicao == tamanho){
			removeLast();;
		}else {
			No<T> anterior = getNo(posicao - 1);
			No<T> atual = getNo(posicao);
			anterior.proximo = atual.proximo;
		}
	}

	@Override
	public T get(int posicao) throws Exception {
		No<T> elemento = getNo(posicao);
		return elemento.dado;
	}

	@Override
	public int size() {
		int i = 0;
		if(!isEmpty()) {
			No<T> aux = primeiro;
			while(aux != null) {
				i++;
				aux = aux.proximo;
			}
		}
		return i;
	}

	
	private No<T> getNo(int posicao) throws Exception{
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if(posicao < 0 || posicao > tamanho - 1) {
			throw new Exception("Posicao Inválida");
		}
		No<T> aux = new No<T>();
		aux = primeiro;
		int i = 0;
		
		while(i < posicao) {
			aux = aux.proximo;
			i++;
		}
		
		return aux;
	}
}
