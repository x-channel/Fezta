package br.NOZ.fezta.exceptions;

public class EventoNaoExiste extends Exception{

	private String eventoInexistente;
	
	public EventoNaoExiste(String evento)
	{
		super("Evento " + evento + " não existe.");
		eventoInexistente = evento;
	}

	public String getEventoInexistente() {
		return eventoInexistente;
	}
}
