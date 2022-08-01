const START: &str = "* ";
const END: &str = " *\n";
const CHARACTER : char = '*';

fn main() {
    let start_sentence="Esta es mi primera toma de contacto con Rust y creo que la última";
    println!("{}", start_sentence);
   
    let maxlength=get_max_length(start_sentence);

    let mut sentence= String::from("");
    sentence = add_characters(maxlength, sentence);

    for item in start_sentence.split_whitespace(){
        let mut substring;
        substring=add_start(sentence);
        substring=substring+item;

        let spaces:u8=(maxlength-item.chars().count())as u8;
        if spaces>0{
            sentence = add_spaces(spaces, substring);
            sentence = add_end(sentence);
        }else{
            sentence = add_end(substring);
        }
    }

    sentence = add_characters(maxlength, sentence);
    println!("{sentence}");
}


fn add_characters(mut n_asterisks:usize, mut sentence:String)-> String{
    n_asterisks = n_asterisks + START.chars().count() + END.chars().count();
    for _n in 0..n_asterisks-1 {
        sentence.push(CHARACTER);
    }
    sentence=sentence+"\n";
    return sentence;
}


fn add_start(mut sentence:String)->String{
    sentence.push_str(START);
    return sentence;
}


fn add_end(mut sentence:String)-> String{
    sentence.push_str(END);
    return sentence;
}


fn add_spaces(spaces:u8, mut sentence:String)-> String{
    
    for _n in 0..spaces {
        sentence.push(' ');
    }
    return sentence;
}


fn get_max_length(sentence:&str)->usize{
    let mut length=0;
    for word in sentence.split_whitespace() {
        if word.chars().count() > length {
            length = word.chars().count();
        }
    }
    return length;
}
