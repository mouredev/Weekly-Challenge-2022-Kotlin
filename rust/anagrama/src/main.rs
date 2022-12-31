
fn main() {
    println!("Amor es Anagrama de roma => {}",sort_string(String::from("AmOr"), String::from("Roma")))
}

fn sort_string(str1: String, str2: String) -> bool {
    let mut chars1: Vec<char> = str1.to_lowercase().chars().collect();
    let mut chars2: Vec<char> = str2.to_lowercase().chars().collect();
  
    chars1.sort();
    chars2.sort();
    
    let is_equal:bool = chars1.eq(&chars2);
    return  is_equal;

}