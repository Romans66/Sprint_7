package clienttest;

public abstract class ClientTestConst {
    
    // Данные get параметров
    public static final String GET_PARAM_TRACK = "track";
    
    public static final String GET_PARAM_COURIER_ID = "courierId";
    
    // Константы для ключей Json
    public static final String ID_KEY = "id";
    
    public static final String MESSAGE_KEY = "message";
    
    public static final String OK_KEY = "ok";
    
    // Константы для информационных сообщений Courier
    
    public static final String INFO_MESSAGE_IF_ID_IS_NOT_GET = "Id курьера не найден по запросу, удаление не требуется";
    public static final String ERROR_MESSAGE_FOR_DELETE_WITH_INCORRECT_ID = "Курьера с таким id нет.";
    public static final String ERROR_MESSAGE_FOR_DELETE_WITHOUT_ID = "Недостаточно данных для удаления курьера";
    public static final String ERROR_MESSAGE_FOR_LOGIN_WITHOUT_PARAMETERS = "Недостаточно данных для входа";
    public static final String ERROR_MESSAGE_FOR_LOGIN_WITH_INCORRECT_DATA = "Учетная запись не найдена";
    public static final String ERROR_MESSAGE_WITHOUT_REQUIRED_DATA = "Недостаточно данных для создания учетной записи";
    public static final String ERROR_MESSAGE_FOR_DUPLICATE_COURIER = "Этот логин уже используется";
    
}
