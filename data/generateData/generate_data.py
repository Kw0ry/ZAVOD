from os import path
from json import dump, loads
from pprint import pprint 

class FactoryGeneration:
    """Генерация данных для "Завода"."""
    def __init__(self, 
                 path_to_json_file: str=path.join('..', 'card_with_factories.json'),
                 path_to_txt_file: str=path.join('data_for_factory.txt')):
        self.path_to_json_file = path_to_json_file
        self.path_to_txt_file = path_to_txt_file

    def get_data(self, value: str, index: int):
        if index == 1:
            return {"name": value.strip()}
        elif index == 2:
            return {"question": value.strip()}
        elif index == 3:
            values = value.split(',')
            data = {"yes": {
                            "worker_fatigue": int(values[0][1:]),
                            "amount_of_money": int(values[1]),
                            "pollution": int(values[2][:-2])
                        }
                    }
            return data
        elif index == 4:
            values = value.split(',')
            data = {"no": {
                           "worker_fatigue": int(values[0][1:]),
                           "amount_of_money": int(values[1]),
                           "pollution": int(values[2][:-2])
                        }
                    }
            return data

    def get_need_version(self, data: list):
        new_format_data_list = []
        for values in data:
            new_format = {
                'name': values[0]['name'],
                'question': values[1]['question'],
                'yes': values[2]['yes'],
                'no': values[3]['no'],
            }
            new_format_data_list.append(new_format)
        return new_format_data_list

    def formater_data(self, data: list):
        new_data = []
        some_data = []
        for index, value in enumerate(data):
            if index % 4 == 0 and index != 0:
                new_data.append(some_data)
                some_data = []
            some_data.append(value)
        new_format_version = self.get_need_version(new_data)
        return new_format_version

    def preprocessing_data(self, data: list):
        tmp_data = []
        for value in data:
            if '\n' == value:
                continue
            if '#' in value:
                index = 0
                continue
            if '+' in value or '-\n' in value:
                continue
            index += 1
            tmp_data.append(self.get_data(value, index))
        new_data = self.formater_data(tmp_data)
        return new_data

    def read_json_file(self) -> dict:
        with open(self.path_to_json_file, encoding='utf-8') as f_obj:
            data = loads(f_obj.read())
        return data

    def write_data_to_json_file(self, data: dict):
        with open(self.path_to_json_file, 'w', encoding='utf-8') as f_obj:
            dump(data, f_obj)

    def read_data_from_txt_file(self) -> dict:
        with open(self.path_to_txt_file, encoding='utf-8') as f_obj:
            data = f_obj.readlines()
        return self.preprocessing_data(data)


def write_data_to_list(json_data: dict, txt_data:list, 
                       influences: int, prev_index: int,
                       next_index: int):
    json_data['factories']\
             ['influences']\
             [f'influences_{influences}'] = txt_data[prev_index:next_index]
    return json_data


def main():
    factory_generation = FactoryGeneration()
    data_from_json = factory_generation.read_json_file()
    data_from_txt = factory_generation.read_data_from_txt_file()
    count_factory_tier_one = 15
    count_factory_tier_two = 8
    count_factory_tier_three = 5
    for index, my_index in enumerate((count_factory_tier_one, 
                                      count_factory_tier_two,
                                      count_factory_tier_three)):
        if index == 0:
            prev_index = 0
            next_index = my_index
            influences = 1
        else:
            prev_index = next_index
            next_index += my_index
            influences += 1
        data = write_data_to_list(data_from_json, data_from_txt, 
                                  influences, prev_index, next_index)
    factory_generation.write_data_to_json_file(data)



if __name__ == "__main__":
    main()
