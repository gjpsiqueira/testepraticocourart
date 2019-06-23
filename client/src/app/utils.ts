import * as moment from 'moment'

export default class Utils {
    static convertDate(data: string) { 
        var split = data.split('/');
        var novadata = split[1] + "/" +split[0]+"/"+split[2];
        var data_americana = new Date(novadata); 
        var momentObj = moment(data_americana, 'MM-DD-YYYY');
        var momentString = momentObj.format('YYYY-MM-DD'); 
        return momentString;
     }
}