package packModelo;

public interface IObservable {
	public void addObserver(IObserver o);
    public void removeObserver(IObserver o);
    public void updateObservers();
}