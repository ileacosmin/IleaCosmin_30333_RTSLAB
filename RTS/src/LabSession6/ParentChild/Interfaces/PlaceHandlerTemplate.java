package LabSession6.ParentChild.Interfaces;

public interface PlaceHandlerTemplate {
	public void AddPlace(PlaceTemplate place);

	public PlaceTemplate GetPlaceByName(String Name);

	public String PrintAllPlaces();
}
