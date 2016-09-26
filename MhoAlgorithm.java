
public class MhoAlgorithm {

		//These are experimental values
		int PX;
		int PY;

		int mhoX;
		int mhoY;

		int fenceX;
		int fenceY;



	public static void MhoAlgorithm(String[] args) {
		// This is the algorithm for the mho objects.

		if(PX == mhoX){
			if(PY > mhoY){
				mhoY++;
			}else{
				mhoY--;
			}

			if((fenceY == mhoY) && (fenceX == mhoX){
				<Remove the mho>
			}

			<collision statements here(Via mhos)>

		}else if(playerY == mhoY){
			if(PX > mhoX){
				mhoX++;
			}else{
				mhoX--;
			}

			if((fenceY == mhoY) && (fenceX == mhoX){
				<Remove the mho>
			}

			<collision statements here(Via mho)>

		}else{
			int xmod= mhoX - PX;
			int ymod = mhoY - PY; 

			if(xmod == ymod){
				if( (xmod != Math.abs(xmod)) && (ymod != Math.abs(ymod)) ){
					mhoX++;
					mhoY++;
				}else if( (xmod == Math.abs(xmod)) && (ymod != Math.abs(ymod)) ){
					mhoX--;
					mhoY++;
				}else if( (xmod == Math.abs(xmod)) && (ymod == Math.abs(ymod)) ){
					mhoX--;
					mhoY--;
				}else if( (xmod != Math.abs(xmod)) && (ymod == Math.abs(ymod)) ){
					mhoX++;
					mhoY--;
				}


			}else if(PX >= mhoY){
				if(PX > mhoX){
					mhoX++;
				}else{
					mhoX--;
				}
			}else if(PX <= mhoY){
				if(PY > mhoY){
					mhoY++;
				}else{
					mhoY--;
			}
			}

			if((fenceY == mhoY) && (fenceX == mhoX){
				<Remove the mho>
			}


		}

	}


			   
			   
			   
			   ////////////
			   
			   

			   public static void MhoAlgorithm() {
			// This is the algorithm for the mho objects.

			if(PX == mhoX){
				if(PY > mhoY){
					mhoY++;
				}else{
					mhoY--;
				}

				if((fenceY == mhoY) && (fenceX == mhoX){
					<Remove the mho>
				}

				<collision statements here(Via mhos)>

			}else if(playerY == mhoY){
				if(PX > mhoX){
					mhoX++;
				}else{
					mhoX--;
				}

				if((fenceY == mhoY) && (fenceX == mhoX){
					<Remove the mho>
				}

				<collision statements here(Via mho)>

			}else{
				int xmod= mhoX - PX;
				int ymod = mhoY - PY; 

				if(xmod == ymod){
					if( (xmod != Math.abs(xmod)) && (ymod != Math.abs(ymod)) ){
						mhoX++;
						mhoY++;
					}else if( (xmod == Math.abs(xmod)) && (ymod != Math.abs(ymod)) ){
						mhoX--;
						mhoY++;
					}else if( (xmod == Math.abs(xmod)) && (ymod == Math.abs(ymod)) ){
						mhoX--;
						mhoY--;
					}else if( (xmod != Math.abs(xmod)) && (ymod == Math.abs(ymod)) ){
						mhoX++;
						mhoY--;
					}


				}else if(PX >= mhoY){
					if(PX > mhoX){
						mhoX++;
					}else{
						mhoX--;
					}
				}else if(PX <= mhoY){
					if(PY > mhoY){
						mhoY++;
					}else{
						mhoY--;
				}
				}

				if((fenceY == mhoY) && (fenceX == mhoX){
					<Remove the mho>
				}


			}
	
			   
			   
			   
			   
			   
			   
			   
			   
