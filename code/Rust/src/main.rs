fn long_computation(x: i64) -> i64 { x * x }

fn parametric_predicate(x: i64) -> impl FnMut(&i64) -> bool {
    let c = long_computation(x);
    move |y| { y % c == 0 }
}

fn main() {
    let a_list = 1 .. 100;
    let predicate = parametric_predicate(3);
    let filtered_list = a_list.filter(predicate);
    println!("{:?}", filtered_list.collect::<Vec<i64>>())
}

// [9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99]