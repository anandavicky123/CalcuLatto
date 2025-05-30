#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import com.softgasm.calculatto.R;
public class ${NAME} implements ConversionMethods {


    @Override
   public String[] CategoryList() {
        return new String[]{getString(R.string.allmeasurements)};
    }

    @Override
    public ArrayList<ConverterItems> ItemList(int CategoryPosition, double DefaultValue) {
       ArrayList<ConverterItems> TheList = new ArrayList<>();
       switch (CategoryPosition) {


            default:
                break;
        }

        return TheList;
    }

    @Override
    public double FindValue(int Category, String FromSymbol, double NewValue) {
       
       switch (FromSymbol) {
            case "":
                return NewValue * 000;
            default:
                return NewValue;
        }

        
    }
    
    
    
    
    
    public String getString(@StringRes int StringID) {
        return App.getAppResources().getString(StringID);
    }

    public String ResultLimit(double result) {
        return Filters.rd(result);
    }
}