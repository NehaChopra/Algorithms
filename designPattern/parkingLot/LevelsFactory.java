package designPattern.parkingLot;

class LevelsFactory {
	public static MultipleLevels createObject(String typeOfLevel){
		if(typeOfLevel.equals(levels.Small)){
			return new SmallLevel(1000, levels.Small, 20);
		}else if(typeOfLevel.equals(levels.Medium)){
			return new MediumLevel(1000, levels.Small, 40);
		}else if(typeOfLevel.equals(levels.Large)){
			return new LargeLevel(1000, levels.Small, 100);
		}else{
			return null;
		}
	}
}
