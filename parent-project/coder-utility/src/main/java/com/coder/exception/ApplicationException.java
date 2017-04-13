package com.coder.exception;

public class ApplicationException {
	public static class ConfigException extends BaseException{
		public ConfigException(String message) {
			super(message);
		}
		public ConfigException(Throwable cause) {
			super(cause);
		}
		private static final long serialVersionUID = 1L;
	}
	public static class ManagerException extends BaseException{
		public ManagerException(String message) {
			super(message);
		}
		public ManagerException(Throwable cause) {
			super(cause);
		}
		private static final long serialVersionUID = 1L;
	}
	
	public static class DAOException extends BaseException{
		public DAOException(String message) {
			super(message);
		}
		public DAOException(Throwable cause) {
			super(cause);
		}
		private static final long serialVersionUID = 1L;
	}
	
	public static class ParserException extends BaseException{
		public ParserException(String message) {
			super(message);
		}
		public ParserException(Throwable cause) {
			super(cause);
		}
		private static final long serialVersionUID = 1L;
	}
}
