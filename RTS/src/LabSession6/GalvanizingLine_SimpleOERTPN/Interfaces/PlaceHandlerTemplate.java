package LabSession6.GalvanizingLine_SimpleOERTPN.Interfaces;

public interface PlaceHandlerTemplate {
	public void AddPlace(PlaceTemplate place);

	public PlaceTemplate GetPlaceByName(String Name);

	public String PrintAllPlaces();
}
