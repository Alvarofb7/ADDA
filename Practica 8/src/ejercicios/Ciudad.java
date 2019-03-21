package ejercicios;

public class Ciudad {
	
		private String nombre;
		private Double numHabitantes;
		
		public Ciudad(String nombre, Double numHabitantes) {
			super();
			this.nombre = nombre;
			this.numHabitantes = numHabitantes;
		}
		public static Ciudad create(String nombre) {
			return new Ciudad(nombre, null);
		}
		public static Ciudad create(String[] formato) {
			return new Ciudad(formato[0], Double.parseDouble(formato[1]));
		}
		public static Ciudad create() {
			return new Ciudad("", null);
		}
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Double getNumHabitantes() {
			return numHabitantes;
		}

		public void setNumHabitantes(Double numHabitantes) {
			this.numHabitantes = numHabitantes;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
			result = prime * result + ((numHabitantes == null) ? 0 : numHabitantes.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Ciudad other = (Ciudad) obj;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			if (numHabitantes == null) {
				if (other.numHabitantes != null)
					return false;
			} else if (!numHabitantes.equals(other.numHabitantes))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Ciudad [nombre=" + nombre + ", numHabitantes=" + numHabitantes + "]";
		}
		
		
}
